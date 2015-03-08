package autojson.integration;

import javax.annotation.Generated;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParsingException;

import static javax.json.stream.JsonParser.Event.*;

@Generated("autojson.AutoJsonProcessor")
public final class AutoJson_PrimitiveInt implements autojson.bind.ValueReader<PrimitiveInt> {

    public static final AutoJson_PrimitiveInt INSTANCE = new AutoJson_PrimitiveInt();

    AutoJson_PrimitiveInt() {
    }

    @Override
    public PrimitiveInt read(JsonParser _parser) {
        {
            Event _event = _parser.next();
            if (_event == VALUE_NULL) {
                return null;
            }
            if (_event != START_OBJECT) {
                throw new JsonParsingException("expected: " + START_OBJECT + " but was: " + _event, _parser.getLocation());
            }
        }
        int value = 0;
        Event _event;
        while ((_event = _parser.next()) != END_OBJECT) {
            switch (_parser.getString()) {
                case "value": {
                    value = autojson.bind.lang.PrimitiveIntReader.INSTANCE.read(_parser);
                    break;
                }

                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_PrimitiveInt(value);
    }

}
