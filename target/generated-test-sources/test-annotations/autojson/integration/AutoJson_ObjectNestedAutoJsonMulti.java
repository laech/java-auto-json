package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJsonMulti implements autojson.bind.ValueReader<ObjectNestedAutoJsonMulti> {

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
        while (_parser.next() != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "stringValue": {
                    AutoJson_ObjectString _reader = autojson.bind.ReaderCache.getCachedReader(AutoJson_ObjectString.class);
                    if (_reader == null) {
                        _reader = new AutoJson_ObjectString();
                        autojson.bind.ReaderCache.putCachedReader(_reader);
                    }
                    stringValue = _reader.read(_parser);
                    break;
                }
                case "intValue": {
                    AutoJson_PrimitiveInt _reader = autojson.bind.ReaderCache.getCachedReader(AutoJson_PrimitiveInt.class);
                    if (_reader == null) {
                        _reader = new AutoJson_PrimitiveInt();
                        autojson.bind.ReaderCache.putCachedReader(_reader);
                    }
                    intValue = _reader.read(_parser);
                    break;
                }
                case "longValue": {
                    autojson.bind.lang.PrimitiveLongReader _reader = autojson.bind.ReaderCache.getCachedReader(autojson.bind.lang.PrimitiveLongReader.class);
                    if (_reader == null) {
                        _reader = new autojson.bind.lang.PrimitiveLongReader();
                        autojson.bind.ReaderCache.putCachedReader(_reader);
                    }
                    longValue = _reader.read(_parser);
                    break;
                }
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_ObjectNestedAutoJsonMulti(stringValue, intValue, longValue);
    }

}
