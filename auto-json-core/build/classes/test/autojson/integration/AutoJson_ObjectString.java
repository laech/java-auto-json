package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectString extends autojson.bind.NullableMapper<ObjectString> {

    @Override
    protected ObjectString readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new autojson.bind.JsonBindException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.lang.String value = null;
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
        return new AutoValue_ObjectString(value);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectString element) throws java.io.IOException {
        valueWrite(generator, element);
    }

    private java.lang.String valueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.StringMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.StringMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.StringMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void valueWrite(autojson.stream.JsonGenerator generator, ObjectString element) throws java.io.IOException {
        autojson.bind.java.lang.StringMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.StringMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.StringMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("value");
        mapper.write(generator, element.value());
    }

}
