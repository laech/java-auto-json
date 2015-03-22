package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJson extends autojson.bind.NullableMapper<ObjectNestedAutoJson> {

    private static final autojson.bind.Mapper<autojson.integration.ObjectString> valueMapper = new AutoJson_ObjectString();

    @Override
    protected ObjectNestedAutoJson readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        autojson.integration.ObjectString value = null;
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
        return new AutoValue_ObjectNestedAutoJson(value);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectNestedAutoJson element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("value");
        valueMapper.write(generator, element.value());
        generator.writeEndObject();
    }

}
