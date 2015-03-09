package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectLong implements autojson.bind.ValueReader<ObjectLong> {

    @Override
    public ObjectLong read(javax.json.stream.JsonParser _parser) {
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
        java.lang.Long value = null;
        while (_parser.next() != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "value": {
                    autojson.bind.lang.LongReader _reader = autojson.bind.ReaderCache.getCachedReader(autojson.bind.lang.LongReader.class);
                    if (_reader == null) {
                        _reader = new autojson.bind.lang.LongReader();
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
        return new AutoValue_ObjectLong(value);
    }

}
