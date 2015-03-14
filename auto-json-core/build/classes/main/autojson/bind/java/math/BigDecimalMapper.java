package autojson.bind.java.math;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class BigDecimalMapper extends autojson.bind.NullableMapper<java.math.BigDecimal> {

    @Override
    protected java.math.BigDecimal readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return new java.math.BigDecimal(parser.getString());
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, java.math.BigDecimal value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
