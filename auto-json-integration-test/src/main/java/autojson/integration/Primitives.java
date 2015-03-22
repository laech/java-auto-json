package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import java.math.BigDecimal;

@AutoJson
@AutoValue
abstract class Primitives {
    abstract int intValue();

    abstract long longValue();

    abstract BigDecimal decimalValue();

    abstract boolean booleanValue();

    abstract String stringValue();
}
