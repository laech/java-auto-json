package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_Primitives extends autojson.bind.NullableMapper<Primitives> {

    private static final autojson.internal.bind.java.lang.PrimitiveIntMapper intValueMapper = new autojson.internal.bind.java.lang.PrimitiveIntMapper();
    private static final autojson.internal.bind.java.lang.PrimitiveLongMapper longValueMapper = new autojson.internal.bind.java.lang.PrimitiveLongMapper();
    private static final autojson.bind.Mapper<java.math.BigDecimal> decimalValueMapper = new autojson.internal.bind.java.math.BigDecimalMapper();
    private static final autojson.internal.bind.java.lang.PrimitiveBooleanMapper booleanValueMapper = new autojson.internal.bind.java.lang.PrimitiveBooleanMapper();
    private static final autojson.bind.Mapper<java.lang.String> stringValueMapper = new autojson.internal.bind.java.lang.StringMapper();

    @Override
    protected Primitives readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
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
                    intValue = intValueMapper.read(_parser);
                    break;
                case "longValue":
                    longValue = longValueMapper.read(_parser);
                    break;
                case "decimalValue":
                    decimalValue = decimalValueMapper.read(_parser);
                    break;
                case "booleanValue":
                    booleanValue = booleanValueMapper.read(_parser);
                    break;
                case "stringValue":
                    stringValue = stringValueMapper.read(_parser);
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
        generator.writeName("intValue");
        intValueMapper.write(generator, element.intValue());
        generator.writeName("longValue");
        longValueMapper.write(generator, element.longValue());
        generator.writeName("decimalValue");
        decimalValueMapper.write(generator, element.decimalValue());
        generator.writeName("booleanValue");
        booleanValueMapper.write(generator, element.booleanValue());
        generator.writeName("stringValue");
        stringValueMapper.write(generator, element.stringValue());
        generator.writeEndObject();
    }

}
