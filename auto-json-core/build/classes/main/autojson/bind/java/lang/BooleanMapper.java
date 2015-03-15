package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class BooleanMapper extends autojson.bind.NullableMapper<java.lang.Boolean> {

    @Override
    protected java.lang.Boolean readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getBoolean();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, java.lang.Boolean value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
