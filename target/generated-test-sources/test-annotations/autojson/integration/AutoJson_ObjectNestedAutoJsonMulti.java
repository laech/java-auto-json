package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJsonMulti implements autojson.bind.ValueReader<ObjectNestedAutoJsonMulti> {

    public static final AutoJson_ObjectNestedAutoJsonMulti INSTANCE = new AutoJson_ObjectNestedAutoJsonMulti();

    AutoJson_ObjectNestedAutoJsonMulti() {
    }

    @Override
    public ObjectNestedAutoJsonMulti read(javax.json.stream.JsonParser _parser) {
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
        autojson.integration.ObjectString stringValue = null;
        autojson.integration.PrimitiveInt intValue = null;
        long longValue = 0L;
        javax.json.stream.JsonParser.Event _event;
        while ((_event = _parser.next()) != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "stringValue":
                    stringValue = AutoJson_ObjectString.INSTANCE.read(_parser);
                    break;
                case "intValue":
                    intValue = AutoJson_PrimitiveInt.INSTANCE.read(_parser);
                    break;
                case "longValue":
                    longValue = autojson.bind.lang.PrimitiveLongReader.INSTANCE.read(_parser);
                    break;
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_ObjectNestedAutoJsonMulti(stringValue, intValue, longValue);
    }

}
