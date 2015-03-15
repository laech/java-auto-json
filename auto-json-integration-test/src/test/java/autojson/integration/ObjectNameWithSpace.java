package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

@AutoJson
@AutoValue
abstract class ObjectNameWithSpace {

    @AutoJson.Name("key with spaces")
    abstract String value();

}
