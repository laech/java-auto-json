package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import java.util.List;
import java.util.Set;

@AutoJson
@AutoValue
abstract class ObjectListSetObject {

    abstract List<Set<ObjectInt>> values();

}
