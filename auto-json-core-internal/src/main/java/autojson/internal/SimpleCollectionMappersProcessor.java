package autojson.internal;

import com.google.auto.service.AutoService;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import javax.annotation.processing.Filer;
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
import static javax.lang.model.SourceVersion.latestSupported;

@AutoService(Processor.class)
public final class SimpleCollectionMappersProcessor extends BaseProcessor {

    private static final STGroup STG = new STGroupFile(
            SimpleCollectionMappersProcessor.class.getResource("collection.stg"), "utf-8", '<', '>');

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return singleton(SimpleCollectionMappers.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return latestSupported();
    }

    @Override
    protected void process(TypeElement annotation, Element pkg, RoundEnvironment round) throws IOException {
        List<Model> models = new ArrayList<>();
        SimpleCollectionMappers group = pkg.getAnnotation(SimpleCollectionMappers.class);
        for (SimpleCollectionMapper mapper : group.value()) {
            models.add(new Model(processingEnv, (PackageElement) pkg, mapper));
        }

        Filer filer = processingEnv.getFiler();
        for (Model model : models) {
            String name = model.getGeneratedClassQualifiedName();
            JavaFileObject file = filer.createSourceFile(name, pkg);
            try (Writer writer = file.openWriter()) {
                writer.write(STG.getInstanceOf("main").add("model", model).render());
            }
        }
    }

    static final class Model {
        private final ProcessingEnvironment env;
        private final PackageElement pkg;
        private final SimpleCollectionMapper annotation;

        Model(ProcessingEnvironment env, PackageElement pkg, SimpleCollectionMapper annotation) {
            this.env = env;
            this.pkg = pkg;
            this.annotation = annotation;
        }

        /**
         * Gets the simple name of the generated mapper. e.g. {@code
         * CollectionMapper}.
         */
        public String getGeneratedClassSimpleName() {
            TypeMirror type = getTargetDeclaredType();
            if (type.toString().equals(Void.class.getCanonicalName())) {
                type = getTargetType();
            }
            return env.getTypeUtils().asElement(type).getSimpleName().toString() + "Mapper";
        }

        /**
         * Gets the fully qualified name of the generated mapper. e.g. {@code
         * my.pkg.CollectionMapper}.
         */
        public String getGeneratedClassQualifiedName() {
            return pkg.getQualifiedName() + "." + getGeneratedClassSimpleName();
        }

        /**
         * Gets the fully qualified name of {@link SimpleCollectionMapper#declareAs()}.
         */
        public String getDeclaredTypeQualifiedName() {
            TypeMirror type = getTargetDeclaredType();
            if (type.toString().equals(Void.class.getCanonicalName())) {
                return getTargetType().toString();
            }
            return type.toString();
        }

        /**
         * The fully qualified name of {@link SimpleCollectionMapper#value()}.
         */
        public String getTargetTypeQualifiedName() {
            return getTargetType().toString();
        }

        public String getProcessorClassName() {
            return SimpleCollectionMappersProcessor.class.getCanonicalName();
        }

        public String getPackageName() {
            return pkg.getQualifiedName().toString();
        }

        private TypeMirror getTargetType() {
            try {
                annotation.value();
                throw new RuntimeException("Failed to get annotation type mirror");
            } catch (MirroredTypeException e) {
                return e.getTypeMirror();
            }
        }

        private TypeMirror getTargetDeclaredType() {
            try {
                annotation.declareAs();
                throw new RuntimeException("Failed to get annotation type mirror");
            } catch (MirroredTypeException e) {
                return e.getTypeMirror();
            }
        }
    }

}
