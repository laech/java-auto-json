package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_Primitives extends autojson.bind.NullableMapper<Primitives> {

    @Override
    protected Primitives readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new autojson.bind.JsonBindException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        int intValue = 0;
        long longValue = 0L;
        java.math.BigDecimal decimalValue = null;
        boolean booleanValue = false;
        java.lang.String stringValue = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "intValue":
                    intValue = intValueRead(_parser);
                    break;
                case "longValue":
                    longValue = longValueRead(_parser);
                    break;
                case "decimalValue":
                    decimalValue = decimalValueRead(_parser);
                    break;
                case "booleanValue":
                    booleanValue = booleanValueRead(_parser);
                    break;
                case "stringValue":
                    stringValue = stringValueRead(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_Primitives(intValue, longValue, decimalValue, booleanValue, stringValue);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, Primitives element) throws java.io.IOException {
        generator.writeBeginObject();
        intValueWrite(generator, element);
        longValueWrite(generator, element);
        decimalValueWrite(generator, element);
        booleanValueWrite(generator, element);
        stringValueWrite(generator, element);
        generator.writeEndObject();
    }

    private int intValueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
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

    private java.math.BigDecimal decimalValueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.math.BigDecimalMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.math.BigDecimalMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.math.BigDecimalMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private boolean booleanValueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveBooleanMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveBooleanMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveBooleanMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private java.lang.String stringValueRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.StringMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.StringMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.StringMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void intValueWrite(autojson.stream.JsonGenerator generator, Primitives element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("intValue");
        mapper.write(generator, element.intValue());
    }

    private void longValueWrite(autojson.stream.JsonGenerator generator, Primitives element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveLongMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveLongMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveLongMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("longValue");
        mapper.write(generator, element.longValue());
    }

    private void decimalValueWrite(autojson.stream.JsonGenerator generator, Primitives element) throws java.io.IOException {
        autojson.bind.java.math.BigDecimalMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.math.BigDecimalMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.math.BigDecimalMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("decimalValue");
        mapper.write(generator, element.decimalValue());
    }

    private void booleanValueWrite(autojson.stream.JsonGenerator generator, Primitives element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveBooleanMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveBooleanMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveBooleanMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("booleanValue");
        mapper.write(generator, element.booleanValue());
    }

    private void stringValueWrite(autojson.stream.JsonGenerator generator, Primitives element) throws java.io.IOException {
        autojson.bind.java.lang.StringMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.StringMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.StringMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("stringValue");
        mapper.write(generator, element.stringValue());
    }

}
