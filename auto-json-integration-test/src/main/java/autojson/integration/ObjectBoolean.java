package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

@AutoJson
@AutoValue
abstract class ObjectBoolean {

    @Nullable
    abstract Boolean value();

}
