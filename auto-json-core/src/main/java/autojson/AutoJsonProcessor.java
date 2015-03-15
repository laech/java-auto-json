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
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Set;

import static java.util.Collections.singleton;
import static javax.lang.model.SourceVersion.latestSupported;
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
            } catch (AbortProcessingException e) {
                // continue to next type
            } catch (Exception e) {
                // Make better error message for all exceptions
                StringWriter writer = new StringWriter();
                e.printStackTrace(new PrintWriter(writer));
                processingEnv.getMessager().printMessage(ERROR, writer.toString(), element);
            }
        }
        return false;
    }

    private void process(TypeElement element) throws IOException {
        TemplateModel model = new TemplateModel(element, this);
        Name qualifiedName = model.getGeneratedQualifiedTypeName();
        JavaFileObject object = processingEnv.getFiler().createSourceFile(qualifiedName, element);
        try (Writer w = object.openWriter()) {
            w.write(STG.getInstanceOf("main").add("model", model).render());
        }
    }

}
