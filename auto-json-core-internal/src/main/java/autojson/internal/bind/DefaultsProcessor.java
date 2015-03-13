package autojson.internal.bind;

import com.google.auto.service.AutoService;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;
import static javax.lang.model.SourceVersion.latestSupported;
import static javax.tools.Diagnostic.Kind.ERROR;

@AutoService(Processor.class)
public final class DefaultsProcessor extends AbstractProcessor {

    private static final STGroup STG_PRIMITIVE = new STGroupFile(
            DefaultsProcessor.class.getResource("primitive.stg"), "utf-8", '<', '>');

    private static final STGroup STG_OBJECT = new STGroupFile(
            DefaultsProcessor.class.getResource("object.stg"), "utf-8", '<', '>');

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return singleton(Defaults.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Defaults.class)) {
            try {
                generate(element);
            } catch (Exception e) {
                // TODO don't duplicate this
                // Make better error message for all exceptions
                StringWriter writer = new StringWriter();
                e.printStackTrace(new PrintWriter(writer));
                processingEnv.getMessager().printMessage(ERROR, writer.toString(), element);
            }
        }
        return false;
    }

    private void generate(Element element) throws IOException {
        List<Model> models = asList(
                new Model(STG_PRIMITIVE, "autojson.bind.java.lang", "PrimitiveBooleanMapper", "boolean", "parser.getBoolean()"),
                new Model(STG_PRIMITIVE, "autojson.bind.java.lang", "PrimitiveIntMapper", "int", "parser.getInt()"),
                new Model(STG_PRIMITIVE, "autojson.bind.java.lang", "PrimitiveLongMapper", "long", "parser.getLong()"),
                new Model(STG_OBJECT, "autojson.bind.java.lang", "BooleanMapper", "Boolean", "parser.getBoolean()"),
                new Model(STG_OBJECT, "autojson.bind.java.lang", "IntegerMapper", "Integer", "parser.getInt()"),
                new Model(STG_OBJECT, "autojson.bind.java.lang", "LongMapper", "Long", "parser.getLong()"),
                new Model(STG_OBJECT, "autojson.bind.java.lang", "StringMapper", "String", "parser.getString()"),
                new Model(STG_OBJECT, "autojson.bind.java.math", "BigDecimalMapper", "java.math.BigDecimal", "new java.math.BigDecimal(parser.getString())")
        );
        for (Model model : models) {
            JavaFileObject file = processingEnv.getFiler().createSourceFile(model.packageName + "." + model.className, element);
            try (Writer writer = file.openWriter()) {
                writer.write(model.template.getInstanceOf("main").add("model", model).render());
            }
        }
    }

    static final class Model {
        public final STGroup template;
        public final String packageName;
        public final String className;
        public final String type;
        public final String parserMethodName;

        Model(STGroup template, String packageName, String className, String type, String parserMethodName) {
            this.template = template;
            this.packageName = packageName;
            this.className = className;
            this.type = type;
            this.parserMethodName = parserMethodName;
        }

        public String getProcessorClassName() {
            return DefaultsProcessor.class.getCanonicalName();
        }

    }

}
