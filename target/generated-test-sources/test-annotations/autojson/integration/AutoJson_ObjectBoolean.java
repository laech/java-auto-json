package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectBoolean implements autojson.bind.ValueReader<ObjectBoolean> {

    public static final AutoJson_ObjectBoolean INSTANCE = new AutoJson_ObjectBoolean();

    AutoJson_ObjectBoolean() {
    }

    @Override
    public ObjectBoolean read(javax.json.stream.JsonParser _parser) {
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
        java.lang.Boolean value = null;
        javax.json.stream.JsonParser.Event _event;
        while ((_event = _parser.next()) != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "value":
                    value = autojson.bind.lang.BooleanReader.INSTANCE.read(_parser);
                    break;
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_ObjectBoolean(value);
    }

}
