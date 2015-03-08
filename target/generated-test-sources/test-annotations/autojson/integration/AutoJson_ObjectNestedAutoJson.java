package autojson.integration;

import javax.annotation.Generated;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParsingException;

import static javax.json.stream.JsonParser.Event.*;

@Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJson implements autojson.bind.ValueReader<ObjectNestedAutoJson> {

    public static final AutoJson_ObjectNestedAutoJson INSTANCE = new AutoJson_ObjectNestedAutoJson();

    AutoJson_ObjectNestedAutoJson() {
    }

    @Override
    public ObjectNestedAutoJson read(JsonParser _parser) {
        {
            Event _event = _parser.next();
            if (_event == VALUE_NULL) {
                return null;
            }
            if (_event != START_OBJECT) {
                throw new JsonParsingException("expected: " + START_OBJECT + " but was: " + _event, _parser.getLocation());
            }
        }
        autojson.integration.ObjectString value = null;
        Event _event;
        while ((_event = _parser.next()) != END_OBJECT) {
            switch (_parser.getString()) {
                case "value": {
                    value = AutoJson_ObjectString.INSTANCE.read(_parser);
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
