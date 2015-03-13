package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJsonMulti extends autojson.bind.NullableMapper<ObjectNestedAutoJsonMulti> {

    @Override
    protected ObjectNestedAutoJsonMulti readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new autojson.bind.JsonBindException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        autojson.integration.ObjectString stringValue = null;
        autojson.integration.PrimitiveInt intValue = null;
        long longValue = 0L;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "stringValue":
                    stringValue = stringValueRead(_parser);
                    break;
                case "intValue":
                    intValue = intValueRead(_parser);
                    break;
                case "longValue":
                    longValue = longValueRead(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectNestedAutoJsonMulti(stringValue, intValue, longValue);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectNestedAutoJsonMulti element) throws java.io.IOException {
        stringValueWrite(generator, element);
        intValueWrite(generator, element);
        longValueWrite(generator, element);
    }

    private autojson.integration.ObjectString stringValueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        AutoJson_ObjectString mapper = autojson.bind.MapperCache.get(AutoJson_ObjectString.class);
        if (mapper == null) {
            mapper = new AutoJson_ObjectString();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private autojson.integration.PrimitiveInt intValueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        AutoJson_PrimitiveInt mapper = autojson.bind.MapperCache.get(AutoJson_PrimitiveInt.class);
        if (mapper == null) {
            mapper = new AutoJson_PrimitiveInt();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private long longValueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveLongMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveLongMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveLongMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void stringValueWrite(autojson.stream.JsonGenerator generator, ObjectNestedAutoJsonMulti element) throws java.io.IOException {
        AutoJson_ObjectString mapper = autojson.bind.MapperCache.get(AutoJson_ObjectString.class);
        if (mapper == null) {
            mapper = new AutoJson_ObjectString();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("stringValue");
        mapper.write(generator, element.stringValue());
    }

    private void intValueWrite(autojson.stream.JsonGenerator generator, ObjectNestedAutoJsonMulti element) throws java.io.IOException {
        AutoJson_PrimitiveInt mapper = autojson.bind.MapperCache.get(AutoJson_PrimitiveInt.class);
        if (mapper == null) {
            mapper = new AutoJson_PrimitiveInt();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("intValue");
        mapper.write(generator, element.intValue());
    }

    private void longValueWrite(autojson.stream.JsonGenerator generator, ObjectNestedAutoJsonMulti element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveLongMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveLongMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveLongMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("longValue");
        mapper.write(generator, element.longValue());
    }

}
