package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectStaticInnerClass_Inner implements autojson.bind.ValueReader<ObjectStaticInnerClass.Inner> {

    public static final AutoJson_ObjectStaticInnerClass_Inner INSTANCE = new AutoJson_ObjectStaticInnerClass_Inner();

    AutoJson_ObjectStaticInnerClass_Inner() {
    }

    @Override
    public ObjectStaticInnerClass.Inner read(javax.json.stream.JsonParser _parser) {
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
        java.lang.String value = null;
        javax.json.stream.JsonParser.Event _event;
        while ((_event = _parser.next()) != javax.json.stream.JsonParser.Event.END_OBJECT) {
            switch (_parser.getString()) {
                case "value":
                    value = autojson.bind.lang.StringReader.INSTANCE.read(_parser);
                    break;
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_ObjectStaticInnerClass_Inner(value);
    }

}
