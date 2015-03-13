package autojson;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.List;

interface Creator {

    List<Variable> getVariables(ProcessingEnvironment env, TypeElement element);

    String getCreationSource(ProcessingEnvironment env, TypeElement element, List<Variable> variables);

}
