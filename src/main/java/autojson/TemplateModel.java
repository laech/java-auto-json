package autojson;

import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.util.List;

import static autojson.Elements.getQualifiedNameWithoutPackage;

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
        return util.getName(getQualifiedNameWithoutPackage(getPackage(), getTargetElement()));
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
        return "AutoJson_" + getQualifiedNameWithoutPackage(pkg, element).replaceAll("\\.", "_");
    }

    public List<Variable> getVariables() {
        return new AutoValueCreator().getVariables(getProcessor().getProcessingEnvironment(), getTargetElement());
    }

    public String getCreationSource() {
        return new AutoValueCreator().getCreationSource(getProcessor().getProcessingEnvironment(), getTargetElement(), getVariables());
    }
}
