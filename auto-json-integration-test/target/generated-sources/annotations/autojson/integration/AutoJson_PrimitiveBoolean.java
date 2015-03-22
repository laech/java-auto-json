package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_PrimitiveBoolean extends autojson.bind.NullableMapper<PrimitiveBoolean> {

    private static final autojson.internal.bind.java.lang.PrimitiveBooleanMapper valueMapper = new autojson.internal.bind.java.lang.PrimitiveBooleanMapper();

    @Override
    protected PrimitiveBoolean readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        boolean value = false;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "value":
                    value = valueMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_PrimitiveBoolean(value);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, PrimitiveBoolean element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("value");
        valueMapper.write(generator, element.value());
        generator.writeEndObject();
    }

}
