package autojson.integration;

import javax.annotation.Generated;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParsingException;

import static javax.json.stream.JsonParser.Event.*;

@Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectEmpty implements autojson.bind.ValueReader<ObjectEmpty> {

    public static final AutoJson_ObjectEmpty INSTANCE = new AutoJson_ObjectEmpty();

    AutoJson_ObjectEmpty() {
    }

    @Override
    public ObjectEmpty read(JsonParser _parser) {
        {
            Event _event = _parser.next();
            if (_event == VALUE_NULL) {
                return null;
            }
            if (_event != START_OBJECT) {
                throw new JsonParsingException("expected: " + START_OBJECT + " but was: " + _event, _parser.getLocation());
            }
        }
        Event _event;
        while ((_event = _parser.next()) != END_OBJECT) {
            switch (_parser.getString()) {
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_ObjectEmpty();
    }

}
