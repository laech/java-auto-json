package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoJson
@AutoValue
abstract class ObjectListObject {

    abstract List<ObjectString> values();

}
