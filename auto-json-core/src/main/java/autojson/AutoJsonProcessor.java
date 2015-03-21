package autojson;

import autojson.internal.BaseProcessor;
import com.google.auto.service.AutoService;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import static java.util.Collections.singleton;
import static javax.lang.model.SourceVersion.latestSupported;

@AutoService(Processor.class)
public final class AutoJsonProcessor extends BaseProcessor {

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

    @Override
    protected void process(TypeElement annotation, Element element, RoundEnvironment round) throws IOException {
        TemplateModel model = new TemplateModel((TypeElement) element, this);
        Name qualifiedName = model.getGeneratedQualifiedTypeName();
        JavaFileObject object = processingEnv.getFiler().createSourceFile(qualifiedName, element);
        try (Writer w = object.openWriter()) {
            w.write(STG.getInstanceOf("main").add("model", model).render());
        }
    }

    ProcessingEnvironment getProcessingEnvironment() {
        return processingEnv;
    }

}
