package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class LongMapper extends autojson.bind.NullableMapper<Long> {

    @Override
    protected Long readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getLong();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, Long value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
