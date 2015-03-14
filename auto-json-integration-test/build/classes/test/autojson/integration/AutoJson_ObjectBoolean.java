package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectBoolean extends autojson.bind.NullableMapper<ObjectBoolean> {

    @Override
    protected ObjectBoolean readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new autojson.bind.JsonBindException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.lang.Boolean value = null;
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
        return new AutoValue_ObjectBoolean(value);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectBoolean element) throws java.io.IOException {
        valueWrite(generator, element);
    }

    private java.lang.Boolean valueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.BooleanMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.BooleanMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.BooleanMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void valueWrite(autojson.stream.JsonGenerator generator, ObjectBoolean element) throws java.io.IOException {
        autojson.bind.java.lang.BooleanMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.BooleanMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.BooleanMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("value");
        mapper.write(generator, element.value());
    }

}
