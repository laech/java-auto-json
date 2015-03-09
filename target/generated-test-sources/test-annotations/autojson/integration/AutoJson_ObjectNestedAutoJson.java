package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJson implements autojson.bind.ValueReader<ObjectNestedAutoJson> {

    @Override
    public ObjectNestedAutoJson read(javax.json.stream.JsonParser _parser) {
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
        autojson.integration.ObjectString value = null;
        while (_parser.next() != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "value": {
                    AutoJson_ObjectString _reader = autojson.bind.ReaderCache.getCachedReader(AutoJson_ObjectString.class);
                    if (_reader == null) {
                        _reader = new AutoJson_ObjectString();
                        autojson.bind.ReaderCache.putCachedReader(_reader);
                    }
                    value = _reader.read(_parser);
                    break;
                }
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_ObjectNestedAutoJson(value);
    }

}
