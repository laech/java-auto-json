package autojson;

import autojson.bind.Mapper;
import autojson.bind.java.lang.BooleanMapper;
import autojson.bind.java.lang.IntegerMapper;
import autojson.bind.java.lang.LongMapper;
import autojson.bind.java.lang.PrimitiveBooleanMapper;
import autojson.bind.java.lang.PrimitiveIntMapper;
import autojson.bind.java.lang.PrimitiveLongMapper;
import autojson.bind.java.lang.StringMapper;
import autojson.bind.java.math.BigDecimalMapper;
import autojson.bind.java.util.ListMapper;
import autojson.bind.java.util.SetMapper;
import autovalue.shaded.com.google.common.common.base.Joiner;
import com.google.common.base.Strings;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static autojson.TemplateModel.getGeneratedTypeName;
import static javax.tools.Diagnostic.Kind.ERROR;

final class Variable {

    private static final Map<String, String> mappers;

    public static void main(String[] args) {
        System.out.println(int.class.getCanonicalName());
    }

    static {
        mappers = new HashMap<>();
        mappers.put(boolean.class.getCanonicalName(), PrimitiveBooleanMapper.class.getCanonicalName());
        mappers.put(int.class.getCanonicalName(), PrimitiveIntMapper.class.getCanonicalName());
        mappers.put(long.class.getCanonicalName(), PrimitiveLongMapper.class.getCanonicalName());
        mappers.put(Boolean.class.getCanonicalName(), BooleanMapper.class.getCanonicalName());
        mappers.put(Integer.class.getCanonicalName(), IntegerMapper.class.getCanonicalName());
        mappers.put(Long.class.getCanonicalName(), LongMapper.class.getCanonicalName());
        mappers.put(String.class.getCanonicalName(), StringMapper.class.getCanonicalName());
        mappers.put(BigDecimal.class.getCanonicalName(), BigDecimalMapper.class.getCanonicalName());
        mappers.put(List.class.getCanonicalName(), ListMapper.class.getCanonicalName());
        mappers.put(Set.class.getCanonicalName(), SetMapper.class.getCanonicalName());
    }

    private final ProcessingEnvironment env;
    private final Element element;
    private final TypeMirror type;
    private final String varName;
    private final String jsonName;
    private final String valueAccessorSource;
    private final String defaultValueSource;

    Variable(ProcessingEnvironment env, Element element, TypeMirror type, String varName, String jsonName, String valueAccessorSource) {
        this(env, element, type, varName, jsonName, valueAccessorSource, Defaults.getSource(type));
    }

    Variable(ProcessingEnvironment env, Element element, TypeMirror type, String varName, String jsonName, String valueAccessorSource, String defaultValueSource) {
        this.env = env;
        this.element = element;
        this.type = type;
        this.varName = varName;
        this.jsonName = jsonName;
        this.valueAccessorSource = valueAccessorSource;
        this.defaultValueSource = defaultValueSource;
    }

    public TypeMirror getType() {
        return type;
    }

    /**
     * The name of this variable to use in Java source.
     */
    public String getVarName() {
        return varName;
    }

    /**
     * The name of this variable as the JSON field.
     */
    public String getJsonName() {
        return jsonName;
    }

    public String getValueAccessorSource() {
        return valueAccessorSource; // TODO
    }

    public String getDefaultValueSource() {
        return defaultValueSource;
    }

    private TypeElement getTypeElement() {
        return (TypeElement) env.getTypeUtils().asElement(getType());
    }

    public MapperVar getMapper() {
        String type = getType().getKind().isPrimitive()
                ? getMapperClassName()
                : Mapper.class.getCanonicalName() + "<" + getType() + ">";
        String name = getVarName() + "Mapper";
        List<String> classes = getMapperClassNames();
        String creation = "new " + Joiner.on("(new ").join(classes) + "(" + Strings.repeat(")", classes.size());
        return MapperVar.create(type, name, creation);
    }

    private static boolean isAutoJson(TypeElement type) {
        return type != null && type.getAnnotation(AutoJson.class) != null;
    }

    private List<TypeMirror> unwrap(TypeMirror type, List<TypeMirror> result) {
        result.add(type);
        if (type instanceof DeclaredType) {
            TypeElement element = (TypeElement) env.getTypeUtils().asElement(type);
            String name = element.getQualifiedName().toString();
            if (name.equals(Set.class.getCanonicalName()) || name.equals(List.class.getCanonicalName())) {
                TypeMirror arg = ((DeclaredType) type).getTypeArguments().get(0);
                unwrap(arg, result);
            }
        }
        return result;
    }

    public List<String> getMapperClassNames() {
        List<TypeMirror> types = unwrap(getType(), new ArrayList<TypeMirror>());
        List<String> mappers = new ArrayList<>(types.size());
        for (TypeMirror type : types) {
            mappers.add(getMapperClassName(type));
        }
        return mappers;
    }

    public String getMapperClassName() {
        return getMapperClassName(getType());
    }

    private String getMapperClassName(TypeMirror type) {
        TypeElement element = (TypeElement) env.getTypeUtils().asElement(type);
        if (isAutoJson(element)) {
            return getAutoJsonGeneratedTypeName(element);
        } else {
            String name = type.toString();
            if (element != null) {
                name = element.getQualifiedName().toString();
            }
            String mapper = mappers.get(name);
            if (mapper == null) {
                env.getMessager().printMessage(ERROR, "No mapper found for " + type, element);
                throw new AbortProcessingException();
            }
            return mapper;
        }
    }

    private String getAutoJsonGeneratedTypeName(TypeElement type) {
        Elements util = env.getElementUtils();
        return getGeneratedTypeName(util.getPackageOf(type), type);
    }

}
