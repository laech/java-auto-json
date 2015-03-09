package autojson.bind;

import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParsingException;

public class JsonBindException extends JsonParsingException {

    public JsonBindException(String message, JsonLocation location) {
        super(message, location);
    }

    public JsonBindException(String message, Throwable cause, JsonLocation location) {
        super(message, cause, location);
    }

}
