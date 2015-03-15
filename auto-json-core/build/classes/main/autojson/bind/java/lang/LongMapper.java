package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class LongMapper extends autojson.bind.NullableMapper<java.lang.Long> {

    @Override
    protected java.lang.Long readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getLong();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, java.lang.Long value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
