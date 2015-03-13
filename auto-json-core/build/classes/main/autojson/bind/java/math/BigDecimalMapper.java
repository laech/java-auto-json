package autojson.bind.java.math;

import autojson.bind.NullableMapper;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import javax.annotation.Generated;

@Generated("autojson.internal.bind.DefaultsProcessor")
public final class BigDecimalMapper extends NullableMapper<java.math.BigDecimal> {

    @Override
    protected java.math.BigDecimal readNotNull(JsonParser parser) throws java.io.IOException {
        return new java.math.BigDecimal(parser.getString());
    }

    @Override
    protected void writeNotNull(JsonGenerator generator, java.math.BigDecimal value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
