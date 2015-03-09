package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_Primitives implements autojson.bind.ValueReader<Primitives> {

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
        while (_parser.next() != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "intValue": {
                    autojson.bind.lang.PrimitiveIntReader _reader = autojson.bind.ReaderCache.getCachedReader(autojson.bind.lang.PrimitiveIntReader.class);
                    if (_reader == null) {
                        _reader = new autojson.bind.lang.PrimitiveIntReader();
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
                case "decimalValue": {
                    autojson.bind.math.BigDecimalReader _reader = autojson.bind.ReaderCache.getCachedReader(autojson.bind.math.BigDecimalReader.class);
                    if (_reader == null) {
                        _reader = new autojson.bind.math.BigDecimalReader();
                        autojson.bind.ReaderCache.putCachedReader(_reader);
                    }
                    decimalValue = _reader.read(_parser);
                    break;
                }
                case "booleanValue": {
                    autojson.bind.lang.PrimitiveBooleanReader _reader = autojson.bind.ReaderCache.getCachedReader(autojson.bind.lang.PrimitiveBooleanReader.class);
                    if (_reader == null) {
                        _reader = new autojson.bind.lang.PrimitiveBooleanReader();
                        autojson.bind.ReaderCache.putCachedReader(_reader);
                    }
                    booleanValue = _reader.read(_parser);
                    break;
                }
                case "stringValue": {
                    autojson.bind.lang.StringReader _reader = autojson.bind.ReaderCache.getCachedReader(autojson.bind.lang.StringReader.class);
                    if (_reader == null) {
                        _reader = new autojson.bind.lang.StringReader();
                        autojson.bind.ReaderCache.putCachedReader(_reader);
                    }
                    stringValue = _reader.read(_parser);
                    break;
                }
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_Primitives(intValue, longValue, decimalValue, booleanValue, stringValue);
    }

}
