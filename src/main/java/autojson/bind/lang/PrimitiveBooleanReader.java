package autojson.bind.lang;

import autojson.bind.JsonBindException;

import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class PrimitiveBooleanReader {

    public boolean read(JsonParser parser) {
        Event event = parser.next();
        switch (event) {
            case VALUE_FALSE:
                return false;
            case VALUE_TRUE:
                return true;
            default:
                JsonLocation location = parser.getLocation();
                throw new JsonBindException(location.toString(), location);
        }
    }

}
