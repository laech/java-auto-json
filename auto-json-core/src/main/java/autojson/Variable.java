package autojson;

import autojson.bind.Mapper;
import autojson.internal.bind.java.lang.BooleanMapper;
import autojson.internal.bind.java.lang.IntegerMapper;
import autojson.internal.bind.java.lang.LongMapper;
import autojson.internal.bind.java.lang.PrimitiveBooleanMapper;
import autojson.internal.bind.java.lang.PrimitiveIntMapper;
import autojson.internal.bind.java.lang.PrimitiveLongMapper;
import autojson.internal.bind.java.lang.StringMapper;
import autojson.internal.bind.java.math.BigDecimalMapper;
import autojson.internal.bind.java.util.ArrayListMapper;
import autojson.internal.bind.java.util.CollectionMapper;
import autojson.internal.bind.java.util.HashSetMapper;
import autojson.internal.bind.java.util.LinkedHashSetMapper;
import autojson.internal.bind.java.util.LinkedListMapper;
import autojson.internal.bind.java.util.ListMapper;
import autojson.internal.bind.java.util.NavigableSetMapper;
import autojson.internal.bind.java.util.SetMapper;
import autojson.internal.bind.java.util.TreeSetMapper;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import static autojson.TemplateModel.getGeneratedTypeName;
import static javax.tools.Diagnostic.Kind.ERROR;

final class Variable {

    private static final Map<String, String> mappers;

    static {
        // TODO better registration
        mappers = new HashMap<>();
        mappers.put(boolean.class.getCanonicalName(), PrimitiveBooleanMapper.class.getCanonicalName());
        mappers.put(int.class.getCanonicalName(), PrimitiveIntMapper.class.getCanonicalName());
        mappers.put(long.class.getCanonicalName(), PrimitiveLongMapper.class.getCanonicalName());
        mappers.put(Boolean.class.getCanonicalName(), BooleanMapper.class.getCanonicalName());
        mappers.put(Integer.class.getCanonicalName(), IntegerMapper.class.getCanonicalName());
        mappers.put(Long.class.getCanonicalName(), LongMapper.class.getCanonicalName());
        mappers.put(String.class.getCanonicalName(), StringMapper.class.getCanonicalName());
        mappers.put(BigDecimal.class.getCanonicalName(), BigDecimalMapper.class.getCanonicalName());
        mappers.put(ArrayList.class.getCanonicalName(), ArrayListMapper.class.getCanonicalName());
        mappers.put(LinkedList.class.getCanonicalName(), LinkedListMapper.class.getCanonicalName());
        mappers.put(List.class.getCanonicalName(), ListMapper.class.getCanonicalName());
        mappers.put(HashSet.class.getCanonicalName(), HashSetMapper.class.getCanonicalName());
        mappers.put(LinkedHashSet.class.getCanonicalName(), LinkedHashSetMapper.class.getCanonicalName());
        mappers.put(TreeSet.class.getCanonicalName(), TreeSetMapper.class.getCanonicalName());
        mappers.put(NavigableSet.class.getCanonicalName(), NavigableSetMapper.class.getCanonicalName());
        mappers.put(Set.class.getCanonicalName(), SetMapper.class.getCanonicalName());
        mappers.put(Collection.class.getCanonicalName(), CollectionMapper.class.getCanonicalName());
    }

    private final ProcessingEnvironment env;
    private final TypeMirror type;
    private final String varName;
    private final String jsonName;
    private final String valueAccessorSource;
    private final String defaultValueSource;

    Variable(ProcessingEnvironment env, TypeMirror type, String varName, String jsonName, String valueAccessorSource) {
        this(env, type, varName, jsonName, valueAccessorSource, Defaults.getSource(type));
    }

    Variable(ProcessingEnvironment env, TypeMirror type, String varName, String jsonName, String valueAccessorSource, String defaultValueSource) {
        this.env = env;
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

    public MapperVar getMapper() {
        String type = getType().getKind().isPrimitive()
                ? getMapperClassName()
                : Mapper.class.getCanonicalName() + "<" + getType() + ">";

        String name = getVarName() + "Mapper";

        List<TypeMirror> mappers = getMapperTypes();
        StringBuilder creation = new StringBuilder();
        for (TypeMirror mapper : mappers) {
            creation.append("new ");
            creation.append(getMapperClassName(mapper));
            if (mapper instanceof DeclaredType && !((DeclaredType) mapper).getTypeArguments().isEmpty()) {
                creation.append("<>");
            }
            creation.append("(");
        }
        for (int i = 0; i < mappers.size(); i++) {
            creation.append(')');
        }

        return MapperVar.create(type, name, creation.toString());
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

    private List<TypeMirror> getMapperTypes() {
        return unwrap(getType(), new ArrayList<TypeMirror>());
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
