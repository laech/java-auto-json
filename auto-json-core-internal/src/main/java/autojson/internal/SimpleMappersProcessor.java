package autojson.internal;

import com.google.auto.service.AutoService;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.Collections.singleton;
import static java.util.Locale.ENGLISH;
import static javax.lang.model.SourceVersion.latestSupported;

@AutoService(Processor.class)
public final class SimpleMappersProcessor extends BaseProcessor {

    private static final STGroup STG_PRIMITIVE = new STGroupFile(
            SimpleMappersProcessor.class.getResource("primitive.stg"), "utf-8", '<', '>');

    private static final STGroup STG_OBJECT = new STGroupFile(
            SimpleMappersProcessor.class.getResource("object.stg"), "utf-8", '<', '>');

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return singleton(SimpleMappers.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return latestSupported();
    }

    @Override
    protected void process(TypeElement annotation, Element pkg, RoundEnvironment round) throws IOException {
        List<Model> models = new ArrayList<>();
        SimpleMappers group = pkg.getAnnotation(SimpleMappers.class);
        for (SimpleMapper mapper : group.value()) {
            models.add(new Model(processingEnv, (PackageElement) pkg, mapper));
        }

        for (Model model : models) {
            JavaFileObject file = processingEnv.getFiler().createSourceFile(model.getGeneratedClassQualifiedName(), pkg);
            try (Writer writer = file.openWriter()) {
                writer.write(model.getTemplate().getInstanceOf("main").add("model", model).render());
            }
        }
    }

    static final class Model {
        private final ProcessingEnvironment env;
        private final PackageElement pkg;
        private final SimpleMapper annotation;

        Model(ProcessingEnvironment env, PackageElement pkg, SimpleMapper annotation) {
            this.env = env;
            this.pkg = pkg;
            this.annotation = annotation;
        }

        /**
         * Gets the simple name of the generated mapper. e.g. {@code
         * CollectionMapper}.
         */
        public String getGeneratedClassSimpleName() {
            if (!annotation.name().isEmpty()) {
                return annotation.name();
            }
            TypeMirror type = getTargetType();
            String name = env.getTypeUtils().asElement(type).getSimpleName().toString() + "Mapper";
            if (type.getKind().isPrimitive()) {
                name = name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1);
            }
            return name;
        }

        /**
         * Gets the fully qualified name of the generated mapper. e.g. {@code
         * my.pkg.CollectionMapper}.
         */
        public String getGeneratedClassQualifiedName() {
            return pkg.getQualifiedName() + "." + getGeneratedClassSimpleName();
        }

        /**
         * The fully qualified name of {@link SimpleMapper#value()}.
         */
        public String getTargetTypeQualifiedName() {
            return getTargetType().toString();
        }

        STGroup getTemplate() {
            return getTargetType().getKind().isPrimitive() ? STG_PRIMITIVE : STG_OBJECT;
        }

        public String getProcessorClassName() {
            return SimpleMappersProcessor.class.getCanonicalName();
        }

        public String getPackageName() {
            return pkg.getQualifiedName().toString();
        }

        public String getParsingSource() {
            if (!annotation.parse().isEmpty()) {
                return annotation.parse();
            }
            String sub;
            TypeMirror type = getTargetType();
            if (type.getKind().isPrimitive()) {
                sub = type.toString();
                sub = sub.substring(0, 1).toUpperCase(ENGLISH) + sub.substring(1);
            } else {
                sub = env.getTypeUtils().asElement(type).getSimpleName().toString();
            }
            return "parser.get" + sub + "()";
        }

        public String getGeneratingSource() {
            if (!annotation.generate().isEmpty()) {
                return annotation.generate();
            }
            return "generator.writeValue(value)";
        }

        private TypeMirror getTargetType() {
            try {
                annotation.value();
                throw new RuntimeException("Failed to get annotation type mirror");
            } catch (MirroredTypeException e) {
                return e.getTypeMirror();
            }
        }
    }

}
