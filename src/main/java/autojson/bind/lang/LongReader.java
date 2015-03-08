package autojson.bind.lang;

import autojson.bind.JsonBindException;
import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class LongReader extends NullableValueReader<Long> {

    public static final LongReader INSTANCE = new LongReader();

    @Override
    protected Long read(JsonParser parser, Event event) {
        try {
            return parser.getLong();
        } catch (IllegalStateException e) {
            throw JsonBindException.rethrow(parser.getLocation(), event, Long.class, e);
        }
    }

}
