package autojson.internal;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Set;

import static javax.tools.Diagnostic.Kind.ERROR;

public abstract class BaseProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment round) {
        for (TypeElement annotation : annotations) {
            for (Element element : round.getElementsAnnotatedWith(annotation)) {
                try {
                    process(annotation, element, round);
                } catch (Exception e) {
                    // Make better error message for all exceptions
                    StringWriter writer = new StringWriter();
                    e.printStackTrace(new PrintWriter(writer));
                    processingEnv.getMessager().printMessage(ERROR, writer.toString(), element);
                }
            }
        }
        return false;
    }

    protected abstract void process(TypeElement annotation, Element element, RoundEnvironment round) throws IOException;

}
