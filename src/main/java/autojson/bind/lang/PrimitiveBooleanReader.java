package autojson.bind.lang;

import autojson.bind.JsonBindException;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class PrimitiveBooleanReader {

    public static final PrimitiveBooleanReader INSTANCE = new PrimitiveBooleanReader();

    public boolean read(JsonParser parser) {
        Event event = parser.next();
        switch (event) {
            case VALUE_FALSE:
                return false;
            case VALUE_TRUE:
                return true;
            default:
                throw JsonBindException.rethrow(parser.getLocation(), event, "boolean", null);
        }
    }

}
