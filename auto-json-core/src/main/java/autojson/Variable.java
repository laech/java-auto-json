package autojson;

import autojson.bind.java.lang.BooleanMapper;
import autojson.bind.java.lang.IntegerMapper;
import autojson.bind.java.lang.LongMapper;
import autojson.bind.java.lang.PrimitiveBooleanMapper;
import autojson.bind.java.lang.PrimitiveIntMapper;
import autojson.bind.java.lang.PrimitiveLongMapper;
import autojson.bind.java.lang.StringMapper;
import autojson.bind.java.math.BigDecimalMapper;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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

    private boolean isAutoJson() {
        TypeElement type = getTypeElement();
        return type != null && type.getAnnotation(AutoJson.class) != null;
    }

    public String getMapperClassName() {
        if (isAutoJson()) {
            return getAutoJsonGeneratedTypeName();
        } else {
            String mapper = mappers.get(getType().toString());
            if (mapper == null) {
                env.getMessager().printMessage(ERROR, "No mapper found for " + getType(), element);
                throw new AbortProcessingException();
            }
            return mapper;
        }
    }

    private String getAutoJsonGeneratedTypeName() {
        Elements util = env.getElementUtils();
        TypeElement type = getTypeElement();
        return getGeneratedTypeName(util.getPackageOf(type), type);
    }

}
