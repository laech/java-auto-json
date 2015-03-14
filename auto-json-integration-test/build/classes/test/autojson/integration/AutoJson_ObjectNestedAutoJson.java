package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJson extends autojson.bind.NullableMapper<ObjectNestedAutoJson> {

    @Override
    protected ObjectNestedAutoJson readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new autojson.bind.JsonBindException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        autojson.integration.ObjectString value = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "value":
                    value = valueRead(_parser);
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
        valueWrite(generator, element);
    }

    private autojson.integration.ObjectString valueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        AutoJson_ObjectString mapper = autojson.bind.MapperCache.get(AutoJson_ObjectString.class);
        if (mapper == null) {
            mapper = new AutoJson_ObjectString();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void valueWrite(autojson.stream.JsonGenerator generator, ObjectNestedAutoJson element) throws java.io.IOException {
        AutoJson_ObjectString mapper = autojson.bind.MapperCache.get(AutoJson_ObjectString.class);
        if (mapper == null) {
            mapper = new AutoJson_ObjectString();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("value");
        mapper.write(generator, element.value());
    }

}
