package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

@AutoJson
@AutoValue
abstract class ObjectString {
    @Nullable
    abstract String value();
}
