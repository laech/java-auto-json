package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class BooleanMapper extends autojson.bind.NullableMapper<Boolean> {

    @Override
    protected Boolean readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getBoolean();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, Boolean value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
