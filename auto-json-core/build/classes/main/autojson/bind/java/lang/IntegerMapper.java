package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class IntegerMapper extends autojson.bind.NullableMapper<Integer> {

    @Override
    protected Integer readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getInt();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, Integer value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
