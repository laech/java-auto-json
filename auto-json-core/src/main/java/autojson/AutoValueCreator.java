package autojson;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import java.util.ArrayList;
import java.util.List;

import static autojson.Elements.getQualifiedNameWithoutPackage;
import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.type.TypeKind.VOID;
import static javax.lang.model.util.ElementFilter.methodsIn;

final class AutoValueCreator implements Creator {

    private static final STGroup STG = new STGroupFile(
            AutoValueCreator.class.getResource("autovalue.stg"), "utf-8", '<', '>');

    @Override
    public List<Variable> getVariables(ProcessingEnvironment env, TypeElement element) {
        List<Variable> vars = new ArrayList<>();
        for (ExecutableElement method : methodsIn(element.getEnclosedElements())) {
            TypeMirror returnType = method.getReturnType();
            if (method.getModifiers().contains(ABSTRACT) &&
                    method.getParameters().isEmpty() &&
                    returnType.getKind() != VOID) {
                String varName = method.getSimpleName().toString();
                String jsonName = varName;
                AutoJson.Name jsonNameOverride = method.getAnnotation(AutoJson.Name.class);
                if (jsonNameOverride != null) {
                    jsonName = jsonNameOverride.value();
                }
                vars.add(new Variable(env, method, returnType, varName, jsonName, "." + method.getSimpleName() + "()")); // TODO
            }
        }
        return vars;
    }

    @Override
    public String getCreationSource(ProcessingEnvironment env, TypeElement element, List<Variable> variables) {
        return STG.getInstanceOf("main").add("model", new Model(env, element, variables)).render();
    }

    static final class Model {
        private final ProcessingEnvironment env;
        private final TypeElement element;
        private final List<Variable> variables;

        Model(ProcessingEnvironment env, TypeElement element, List<Variable> variables) {
            this.env = env;
            this.element = element;
            this.variables = variables;
        }

        public List<Variable> getVariables() {
            return variables;
        }

        public String getAutoValueTypeName() {
            Elements util = env.getElementUtils();
            PackageElement pkg = util.getPackageOf(element);
            return "AutoValue_" + getQualifiedNameWithoutPackage(pkg, element).replaceAll("\\.", "_");
        }

    }

}
