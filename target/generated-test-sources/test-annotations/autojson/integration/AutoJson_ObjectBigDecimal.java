package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectBigDecimal implements autojson.bind.ValueReader<ObjectBigDecimal> {

    @Override
    public ObjectBigDecimal read(javax.json.stream.JsonParser _parser) {
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
        java.math.BigDecimal value = null;
        while (_parser.next() != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "value": {
                    autojson.bind.math.BigDecimalReader _reader = autojson.bind.ReaderCache.getCachedReader(autojson.bind.math.BigDecimalReader.class);
                    if (_reader == null) {
                        _reader = new autojson.bind.math.BigDecimalReader();
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
        return new AutoValue_ObjectBigDecimal(value);
    }

}
