package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class StringMapper extends autojson.bind.NullableMapper<String> {

    @Override
    protected String readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getString();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, String value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
