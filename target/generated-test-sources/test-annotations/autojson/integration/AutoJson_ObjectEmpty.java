package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectEmpty implements autojson.bind.ValueReader<ObjectEmpty> {

    public static final AutoJson_ObjectEmpty INSTANCE = new AutoJson_ObjectEmpty();

    AutoJson_ObjectEmpty() {
    }

    @Override
    public ObjectEmpty read(javax.json.stream.JsonParser _parser) {
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
        javax.json.stream.JsonParser.Event _event;
        while ((_event = _parser.next()) != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_ObjectEmpty();
    }

}
