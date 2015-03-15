package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_PrimitiveBoolean extends autojson.bind.NullableMapper<PrimitiveBoolean> {

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
                    value = valueRead(_parser);
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
        valueWrite(generator, element);
        generator.writeEndObject();
    }

    private boolean valueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveBooleanMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveBooleanMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveBooleanMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void valueWrite(autojson.stream.JsonGenerator generator, PrimitiveBoolean element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveBooleanMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveBooleanMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveBooleanMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("value");
        mapper.write(generator, element.value());
    }

}
