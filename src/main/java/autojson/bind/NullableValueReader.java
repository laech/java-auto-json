package autojson.bind;

import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import static javax.json.stream.JsonParser.Event.VALUE_NULL;

public abstract class NullableValueReader<T> implements ValueReader<T> {

    @Override
    public final T read(JsonParser parser) {
        Event event = parser.next();
        if (event == VALUE_NULL) {
            return null;
        }
        try {
            return read(parser, event);
        } catch (IllegalStateException e) {
            JsonLocation location = parser.getLocation();
            throw new JsonBindException(location.toString(), e, location);
        }
    }

    protected abstract T read(JsonParser parser, Event event);

}
