package autojson.integration;

import javax.annotation.Generated;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParsingException;

import static javax.json.stream.JsonParser.Event.*;

@Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectBoolean implements autojson.bind.ValueReader<ObjectBoolean> {

    public static final AutoJson_ObjectBoolean INSTANCE = new AutoJson_ObjectBoolean();

    AutoJson_ObjectBoolean() {
    }

    @Override
    public ObjectBoolean read(JsonParser _parser) {
        {
            Event _event = _parser.next();
            if (_event == VALUE_NULL) {
                return null;
            }
            if (_event != START_OBJECT) {
                throw new JsonParsingException("expected: " + START_OBJECT + " but was: " + _event, _parser.getLocation());
            }
        }
        java.lang.Boolean value = null;
        Event _event;
        while ((_event = _parser.next()) != END_OBJECT) {
            switch (_parser.getString()) {
                case "value": {
                    value = autojson.bind.lang.BooleanReader.INSTANCE.read(_parser);
                    break;
                }

                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_ObjectBoolean(value);
    }

}
