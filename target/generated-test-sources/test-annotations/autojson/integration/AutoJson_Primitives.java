package autojson.integration;

import javax.annotation.Generated;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParsingException;

import static javax.json.stream.JsonParser.Event.*;

@Generated("autojson.AutoJsonProcessor")
public final class AutoJson_Primitives implements autojson.bind.ValueReader<Primitives> {

    public static final AutoJson_Primitives INSTANCE = new AutoJson_Primitives();

    AutoJson_Primitives() {
    }

    @Override
    public Primitives read(JsonParser _parser) {
        {
            Event _event = _parser.next();
            if (_event == VALUE_NULL) {
                return null;
            }
            if (_event != START_OBJECT) {
                throw new JsonParsingException("expected: " + START_OBJECT + " but was: " + _event, _parser.getLocation());
            }
        }
        int intValue = 0;
        long longValue = 0;
        java.math.BigDecimal decimalValue = null;
        boolean booleanValue = false;
        java.lang.String stringValue = null;
        Event _event;
        while ((_event = _parser.next()) != END_OBJECT) {
            switch (_parser.getString()) {
                case "intValue":
                    intValue = autojson.bind.lang.PrimitiveIntReader.INSTANCE.read(_parser);
                    break;
                case "longValue":
                    longValue = autojson.bind.lang.PrimitiveLongReader.INSTANCE.read(_parser);
                    break;
                case "decimalValue":
                    decimalValue = autojson.bind.math.BigDecimalReader.INSTANCE.read(_parser);
                    break;
                case "booleanValue":
                    booleanValue = autojson.bind.lang.PrimitiveBooleanReader.INSTANCE.read(_parser);
                    break;
                case "stringValue":
                    stringValue = autojson.bind.lang.StringReader.INSTANCE.read(_parser);
                    break;
                default:
                    autojson.JsonParsers.skipTree(_parser);
                    break;
            }
        }
        return new AutoValue_Primitives(intValue, longValue, decimalValue, booleanValue, stringValue);
    }

}
