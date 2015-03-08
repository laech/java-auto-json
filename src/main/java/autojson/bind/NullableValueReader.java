package autojson.bind;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import static javax.json.stream.JsonParser.Event.VALUE_NULL;

public abstract class NullableValueReader<T> implements ValueReader<T> {

    @Override
    public T read(JsonParser parser) {
        Event event = parser.next();
        if (event == VALUE_NULL) {
            return null;
        }
        return read(parser, event);
    }

    protected abstract T read(JsonParser parser, Event event);

}
