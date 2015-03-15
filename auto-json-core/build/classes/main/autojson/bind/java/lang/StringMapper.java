package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class StringMapper extends autojson.bind.NullableMapper<java.lang.String> {

    @Override
    protected java.lang.String readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getString();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, java.lang.String value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
