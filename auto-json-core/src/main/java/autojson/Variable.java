package autojson;

import autojson.bind.java.lang.*;
import autojson.bind.java.math.BigDecimalMapper;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static autojson.TemplateModel.getGeneratedTypeName;

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
    private final TypeMirror type;
    private final Name name;
    private final String valueAccessorSource;
    private final String defaultValueSource;

    Variable(ProcessingEnvironment env, TypeMirror type, Name name, String valueAccessorSource) {
        this(env, type, name, valueAccessorSource, Defaults.getSource(type));
    }

    Variable(ProcessingEnvironment env, TypeMirror type, Name name, String valueAccessorSource, String defaultValueSource) {
        this.env = env;
        this.type = type;
        this.name = name;
        this.valueAccessorSource = valueAccessorSource;
        this.defaultValueSource = defaultValueSource;
    }

    public TypeMirror getType() {
        return type;
    }

    public Name getName() {
        return name;
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
            return getAutoJsonGeneratedTypeName().toString();
        } else {
            return mappers.get(getType().toString());
        }
    }

    private Name getAutoJsonGeneratedTypeName() {
        Elements util = env.getElementUtils();
        TypeElement type = getTypeElement();
        return util.getName(getGeneratedTypeName(util.getPackageOf(type), type));
    }

}
