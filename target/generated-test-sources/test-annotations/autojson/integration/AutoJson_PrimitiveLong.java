package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_PrimitiveLong implements autojson.bind.ValueReader<PrimitiveLong> {

    @Override
    public PrimitiveLong read(javax.json.stream.JsonParser _parser) {
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
        long value = 0L;
        while (_parser.next() != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "value": {
                    autojson.bind.lang.PrimitiveLongReader _reader = autojson.bind.ReaderCache.getCachedReader(autojson.bind.lang.PrimitiveLongReader.class);
                    if (_reader == null) {
                        _reader = new autojson.bind.lang.PrimitiveLongReader();
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
        return new AutoValue_PrimitiveLong(value);
    }

}
