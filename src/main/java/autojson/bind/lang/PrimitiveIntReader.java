package autojson.bind.lang;

import autojson.bind.JsonBindException;

import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;

public final class PrimitiveIntReader {

    public int read(JsonParser parser) {
        parser.next();
        try {
            return parser.getInt();
        } catch (IllegalStateException e) {
            JsonLocation location = parser.getLocation();
            throw new JsonBindException(location.toString(), e, location);
        }
    }

}
