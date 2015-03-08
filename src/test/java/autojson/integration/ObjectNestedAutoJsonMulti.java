package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

@AutoJson
@AutoValue
abstract class ObjectNestedAutoJsonMulti {
    abstract ObjectString stringValue();

    abstract PrimitiveInt intValue();

    abstract long longValue();
}
