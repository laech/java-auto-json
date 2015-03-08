package autojson;

import autojson.bind.lang.*;
import autojson.bind.math.BigDecimalReader;

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

    private static final Map<String, String> readers;

    public static void main(String[] args) {
        System.out.println(int.class.getCanonicalName());
    }

    static {
        readers = new HashMap<>();
        readers.put(boolean.class.getCanonicalName(), PrimitiveBooleanReader.class.getCanonicalName());
        readers.put(int.class.getCanonicalName(), PrimitiveIntReader.class.getCanonicalName());
        readers.put(long.class.getCanonicalName(), PrimitiveLongReader.class.getCanonicalName());
        readers.put(Boolean.class.getCanonicalName(), BooleanReader.class.getCanonicalName());
        readers.put(Integer.class.getCanonicalName(), IntegerReader.class.getCanonicalName());
        readers.put(Long.class.getCanonicalName(), LongReader.class.getCanonicalName());
        readers.put(String.class.getCanonicalName(), StringReader.class.getCanonicalName());
        readers.put(BigDecimal.class.getCanonicalName(), BigDecimalReader.class.getCanonicalName());
    }

    private final ProcessingEnvironment env;
    private final TypeMirror type;
    private final Name name;
    private final String defaultValueSource;

    Variable(ProcessingEnvironment env, TypeMirror type, Name name) {
        this(env, type, name, Defaults.getSource(type));
    }

    Variable(ProcessingEnvironment env, TypeMirror type, Name name, String defaultValueSource) {
        this.env = env;
        this.type = type;
        this.name = name;
        this.defaultValueSource = defaultValueSource;
    }

    public TypeMirror getType() {
        return type;
    }

    public Name getName() {
        return name;
    }

    public String getDefaultValueSource() {
        return defaultValueSource;
    }

    private TypeElement getTypeElement() {
        return (TypeElement) env.getTypeUtils().asElement(getType());
    }

    public boolean isAutoJson() {
        TypeElement type = getTypeElement();
        return type != null && type.getAnnotation(AutoJson.class) != null;
    }

    public String getReaderClassName() {
        return readers.get(getType().toString());
    }

    public Name getAutoJsonGeneratedTypeName() {
        Elements util = env.getElementUtils();
        TypeElement type = getTypeElement();
        return util.getName(getGeneratedTypeName(util.getPackageOf(type), type));
    }

}
