package autojson;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import java.util.ArrayList;
import java.util.List;

import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.type.TypeKind.VOID;
import static javax.lang.model.util.ElementFilter.methodsIn;

final class TemplateModel {

    private final TypeElement element;
    private final AutoJsonProcessor processor;

    TemplateModel(TypeElement element, AutoJsonProcessor processor) {
        this.element = element;
        this.processor = processor;
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

    static String getGeneratedTypeName(PackageElement pkg, TypeElement element) {
        return "AutoJson_" + getElementName(pkg, element).replaceAll("\\.", "_");
    }

    public List<Variable> getVariables() {
        List<Variable> vars = new ArrayList<>();
        for (ExecutableElement method : methodsIn(element.getEnclosedElements())) {
            TypeMirror returnType = method.getReturnType();
            if (method.getModifiers().contains(ABSTRACT) &&
                    method.getParameters().isEmpty() &&
                    returnType.getKind() != VOID) {
                vars.add(new Variable(processor.getProcessingEnvironment(), returnType, method.getSimpleName(), getDefaultValue(returnType)));
            }
        }
        return vars;
    }

    private String getDefaultValue(TypeMirror type) {
        switch (type.getKind()) {
            case BOOLEAN:
                return String.valueOf(false);
            case INT:
            case LONG:
                return String.valueOf(0);
            case DECLARED:
                return null;
            default:
                throw new AssertionError("TODO");
        }
    }

}
