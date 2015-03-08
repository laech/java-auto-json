package autojson.integration;

import javax.annotation.Generated;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParsingException;

import static javax.json.stream.JsonParser.Event.*;

@Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJsonMulti implements autojson.bind.ValueReader<ObjectNestedAutoJsonMulti> {

    public static final AutoJson_ObjectNestedAutoJsonMulti INSTANCE = new AutoJson_ObjectNestedAutoJsonMulti();

    AutoJson_ObjectNestedAutoJsonMulti() {
    }

    @Override
    public ObjectNestedAutoJsonMulti read(JsonParser _parser) {
        {
            Event _event = _parser.next();
            if (_event == VALUE_NULL) {
                return null;
            }
            if (_event != START_OBJECT) {
                throw new JsonParsingException("expected: " + START_OBJECT + " but was: " + _event, _parser.getLocation());
            }
        }
        autojson.integration.ObjectString stringValue = null;
        autojson.integration.PrimitiveInt intValue = null;
        long longValue = 0;
        Event _event;
        while ((_event = _parser.next()) != END_OBJECT) {
            switch (_parser.getString()) {
                case "stringValue": {
                    stringValue = AutoJson_ObjectString.INSTANCE.read(_parser);
                    break;
                }
                case "intValue": {
                    intValue = AutoJson_PrimitiveInt.INSTANCE.read(_parser);
                    break;
                }
                case "longValue": {
                    longValue = autojson.bind.lang.PrimitiveLongReader.INSTANCE.read(_parser);
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
