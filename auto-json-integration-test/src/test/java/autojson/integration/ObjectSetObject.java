package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import java.util.Set;

@AutoJson
@AutoValue
abstract class ObjectSetObject {

    abstract Set<ObjectInt> values();

}
