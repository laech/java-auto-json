package autojson;

import com.google.auto.service.AutoService;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.Collections.singleton;
import static javax.lang.model.SourceVersion.latestSupported;
import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.type.TypeKind.VOID;
import static javax.lang.model.util.ElementFilter.methodsIn;
import static javax.tools.Diagnostic.Kind.ERROR;

@AutoService(Processor.class)
public final class AutoJsonProcessor extends AbstractProcessor {

    private static final STGroup STG = new STGroupFile(
            AutoJsonProcessor.class.getResource("autojson.stg"), "utf-8", '<', '>');

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return singleton(AutoJson.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return latestSupported();
    }

    ProcessingEnvironment getProcessingEnvironment() {
        return processingEnv;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment round) {
        for (Element element : round.getElementsAnnotatedWith(AutoJson.class)) {
            try {
                process((TypeElement) element);
            } catch (EarlyReturnException e) {
                // Message has been printed by thrower
            } catch (Exception e) {
                // Make better error message for all exceptions
                StringWriter writer = new StringWriter();
                e.printStackTrace(new PrintWriter(writer));
                processingEnv.getMessager().printMessage(ERROR, writer.toString(), element);
            }
        }
        return false;
    }

    public static class Var {
        public final String type;
        public final String name;
        public final Object defaultValue;

        Var(String type, String name, Object defaultValue) {
            this.type = type;
            this.name = name;
            this.defaultValue = defaultValue;
        }

    }

    private void process(TypeElement element) throws IOException {

        PackageElement pkg = getPackage(element);

        String className = getGeneratedClassName(pkg, element);
        String generatedQualifiedName = pkg.isUnnamed() ? getGeneratedClassName(pkg, element) : pkg.getQualifiedName() + "." + className;

        JavaFileObject object = processingEnv.getFiler().createSourceFile(generatedQualifiedName, element);
        try (Writer w = object.openWriter()) {
            w.write(STG.getInstanceOf("main").add("model", new TemplateModel(element, this)).render());
        }
    }

    private List<Var> findVars(TypeElement element) {
        List<ExecutableElement> methods = methodsIn(element.getEnclosedElements());
        List<Var> vars = new ArrayList<>();
        for (ExecutableElement method : methods) {
            if (method.getModifiers().contains(ABSTRACT) &&
                    method.getParameters().isEmpty() &&
                    method.getReturnType().getKind() != VOID) {
                Object defaultValue = null;
                switch (method.getReturnType().getKind()) {
                    case INT:
                        defaultValue = 0;
                        break;
                    case LONG:
                        defaultValue = 0L;
                        break;
                    case BOOLEAN:
                        defaultValue = false;
                        break;
                }
                vars.add(new Var(method.getReturnType().toString(), method.getSimpleName().toString(), defaultValue));
            }
        }
        return vars;
    }

    private PackageElement getPackage(Element type) {
        return processingEnv.getElementUtils().getPackageOf(type);
    }

    private String getQualifiedNameWithoutPackage(PackageElement pkg, TypeElement element) {
        String name = element.getQualifiedName().toString();
        if (!pkg.isUnnamed()) {
            return name.substring(pkg.getQualifiedName().length() + 1);
        }
        return name;
    }

    private String getGeneratedClassName(PackageElement pkg, TypeElement element) {
        String name = processingEnv.getElementUtils().getBinaryName(element).toString();
        if (!pkg.isUnnamed()) {
            name = name.substring(pkg.getQualifiedName().length() + 1);
        }
        return "AutoJson_" + name.replaceAll("\\$", "_");
    }

    private static class EarlyReturnException extends RuntimeException {
    }
}
