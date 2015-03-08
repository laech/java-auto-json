package autojson.bind;

import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParsingException;

public class JsonBindException extends JsonParsingException {

    public JsonBindException(String message, JsonLocation location) {
        super(message, location);
    }

    public JsonBindException(String message, Throwable cause, JsonLocation location) {
        super(message, cause, location);
    }

    public static JsonBindException rethrow(JsonLocation postLocation, Event actual, Class<?> expected, Throwable cause) {
        return rethrow(postLocation, actual, expected.getCanonicalName(), cause);
    }

    public static JsonBindException rethrow(JsonLocation postLocation, Event actual, String expectedTypeName, Throwable cause) {
        throw new JsonBindException("Failed to read " + expectedTypeName + " preceding " + postLocation + ", unexpected event is " + actual, cause, postLocation);
    }

}
