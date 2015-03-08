package autojson;

import autojson.bind.lang.*;
import autojson.bind.math.BigDecimalReader;

import javax.json.stream.JsonParser;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Locale.ENGLISH;
import static javax.json.stream.JsonParser.Event.*;
import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.type.TypeKind.BOOLEAN;
import static javax.lang.model.type.TypeKind.VOID;
import static javax.lang.model.util.ElementFilter.methodsIn;

final class TemplateModel {

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

    private final TypeElement element;
    private final AutoJsonProcessor processor;

    TemplateModel(TypeElement element, AutoJsonProcessor processor) {
        this.element = element;
        this.processor = processor;
    }

    public String getReaderClassName(String type) {
        return readers.get(type);
    }

    /**
     * The element annotated with {@link AutoJson}.
     */
    public TypeElement getTargetElement() {
        return element;
    }

    /**
     * Gets the name of the target element without the package part,
     * includes the enclosing class name if it is a static inner element.
     */
    public Name getTargetElementName() {
        Elements util = getProcessor().getProcessingEnvironment().getElementUtils();
        return util.getName(getElementName(getPackage(), getTargetElement()));
    }

    private static String getElementName(PackageElement pkg, TypeElement element) {
        String name = element.getQualifiedName().toString();
        if (!pkg.isUnnamed()) {
            name = name.substring(pkg.getQualifiedName().length() + 1);
        }
        return name;
    }

    public AutoJsonProcessor getProcessor() {
        return processor;
    }

    public PackageElement getPackage() {
        return getProcessor()
                .getProcessingEnvironment()
                .getElementUtils()
                .getPackageOf(getTargetElement());
    }

    public Name getGeneratedTypeName() {
        Elements util = getProcessor().getProcessingEnvironment().getElementUtils();
        return util.getName("AutoJson_" + getTargetElementName().toString().replaceAll("\\.", "_"));
    }

    public Name getAutoValueTypeName() {
        Elements util = getProcessor().getProcessingEnvironment().getElementUtils();
        return util.getName("AutoValue_" + getTargetElementName().toString().replaceAll("\\.", "_"));
    }

    private static String getGeneratedTypeName(PackageElement pkg, TypeElement element) {
        return "AutoJson_" + getElementName(pkg, element).toString().replaceAll("\\.", "_");
    }

    public List<Property> getProperties() {
        List<Property> vars = new ArrayList<>();
        for (ExecutableElement method : methodsIn(element.getEnclosedElements())) {
            if (method.getModifiers().contains(ABSTRACT) &&
                    method.getParameters().isEmpty() &&
                    method.getReturnType().getKind() != VOID) {
                vars.add(new Property(method, processor));
            }
        }
        return vars;
    }

    static class Property {

        private final ExecutableElement element;
        private final AutoJsonProcessor processor;

        Property(ExecutableElement element, AutoJsonProcessor processor) {
            this.element = element;
            this.processor = processor;
        }

        public ExecutableElement getElement() {
            return element;
        }

        public AutoJsonProcessor getProcessor() {
            return processor;
        }

        public Name getName() {
            return element.getSimpleName();
        }

        public String getTypeName() {
            TypeMirror type = element.getReturnType();
            if (type.getKind().isPrimitive()) {
                return type.getKind().name().toLowerCase(ENGLISH);
            }
            return type.toString();
        }

        public Object getDefaultValue() {
            switch (getElement().getReturnType().getKind()) {
                case BOOLEAN:
                    return false;
                case INT:
                case LONG:
                    return 0;
                case DECLARED:
                    return null;
                default:
                    throw new AssertionError();
            }
        }

        public JsonParser.Event getEvent() {
            switch (getElement().getReturnType().getKind()) {
                case BOOLEAN:
                    return VALUE_FALSE;
                case INT:
                case LONG:
                    return VALUE_NUMBER;
            }
            String type = getElement().getReturnType().toString();
            if (type.equals(String.class.getCanonicalName())) {
                return VALUE_STRING;
            } else if (type.equals(BigDecimal.class.getCanonicalName())) {
                return VALUE_NUMBER;
            }
            return null;
        }

        public String getEventValue() {
            return getElement().getReturnType().getKind() == BOOLEAN ? "false" : null;
        }

        public String getEventParserMethodName() {
            switch (getElement().getReturnType().getKind()) {
                case INT:
                    return "getInt";
                case LONG:
                    return "getLong";
            }
            String type = getElement().getReturnType().toString();
            if (type.equals(String.class.getCanonicalName())) {
                return "getString";
            } else if (type.equals(BigDecimal.class.getCanonicalName())) {
                return "getBigDecimal";
            }
            return null;
        }

        public Name getAutoJsonGeneratedTypeName() {
            Elements util = getProcessor().getProcessingEnvironment().getElementUtils();
            TypeElement type = getTypeElement();
            return util.getName(getGeneratedTypeName(util.getPackageOf(type), type));
        }

        private TypeElement getTypeElement() {
            return (TypeElement) getProcessor().getProcessingEnvironment().getTypeUtils().asElement(getElement().getReturnType());
        }

        public boolean isAutoJson() {
            TypeElement type = getTypeElement();
            return type != null && type.getAnnotation(AutoJson.class) != null;
        }

        public JsonParser.Event getEvent2() {
            return getElement().getReturnType().getKind() == BOOLEAN ? VALUE_TRUE : null;
        }

        public String getEvent2Value() {
            return getElement().getReturnType().getKind() == BOOLEAN ? "true" : null;
        }

        public String getReaderClassName() {
            TypeKind kind = getElement().getReturnType().getKind();
            return readers.get(kind.isPrimitive() ? kind.name().toLowerCase(ENGLISH) : getTypeElement().getQualifiedName().toString());
        }
    }
}
