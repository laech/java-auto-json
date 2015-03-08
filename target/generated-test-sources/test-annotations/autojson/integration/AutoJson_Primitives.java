package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_Primitives implements autojson.bind.ValueReader<Primitives> {

    public static final AutoJson_Primitives INSTANCE = new AutoJson_Primitives();

    AutoJson_Primitives() {
    }

    @Override
    public Primitives read(javax.json.stream.JsonParser _parser) {
        {
            javax.json.stream.JsonParser.Event _event = _parser.next();
            if (_event == javax.json.stream.JsonParser.Event.VALUE_NULL) {
                return null;
            }
            if (_event != javax.json.stream.JsonParser.Event.START_OBJECT) {
                throw new autojson.bind.JsonBindException(
                        "expected " + javax.json.stream.JsonParser.Event.START_OBJECT +
                                " but was " + _event + " preceding " + _parser.getLocation(),
                                 _parser.getLocation());
            }
        }
        int intValue = 0;
        long longValue = 0L;
        java.math.BigDecimal decimalValue = null;
        boolean booleanValue = false;
        java.lang.String stringValue = null;
        javax.json.stream.JsonParser.Event _event;
        while ((_event = _parser.next()) != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "intValue":
                    intValue = autojson.bind.lang.PrimitiveIntReader.INSTANCE.read(_parser);
                    break;
                case "longValue":
                    longValue = autojson.bind.lang.PrimitiveLongReader.INSTANCE.read(_parser);
                    break;
                case "decimalValue":
                    decimalValue = autojson.bind.math.BigDecimalReader.INSTANCE.read(_parser);
                    break;
                case "booleanValue":
                    booleanValue = autojson.bind.lang.PrimitiveBooleanReader.INSTANCE.read(_parser);
                    break;
                case "stringValue":
                    stringValue = autojson.bind.lang.StringReader.INSTANCE.read(_parser);
                    break;
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_Primitives(intValue, longValue, decimalValue, booleanValue, stringValue);
    }

}
