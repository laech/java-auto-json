package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import java.math.BigDecimal;

@AutoJson
@AutoValue
abstract class ObjectBigDecimal {
    abstract BigDecimal value();
}
