package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

@AutoJson
@AutoValue
abstract class ObjectLong {

    @Nullable
    abstract Long value();

}
