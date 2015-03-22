package autojson.internal.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class IntegerMapper extends autojson.bind.NullableMapper<java.lang.Integer> {

    @Override
    protected java.lang.Integer readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getInt();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, java.lang.Integer value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
