package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNameWithSpace extends autojson.bind.NullableMapper<ObjectNameWithSpace> {

    private static final autojson.bind.Mapper<java.lang.String> valueMapper = new autojson.bind.java.lang.StringMapper();

    @Override
    protected ObjectNameWithSpace readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.lang.String value = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "key with spaces":
                    value = valueMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectNameWithSpace(value);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectNameWithSpace element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("key with spaces");
        valueMapper.write(generator, element.value());
        generator.writeEndObject();
    }

}
