package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

@AutoJson
@AutoValue
abstract class PrimitiveInt {
    abstract int value();
}
