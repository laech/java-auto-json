package autojson.bind.lang;

import autojson.bind.JsonBindException;
import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class IntegerReader extends NullableValueReader<Integer> {

    public static final IntegerReader INSTANCE = new IntegerReader();

    @Override
    protected Integer read(JsonParser parser, Event event) {
        try {
            return parser.getInt();
        } catch (IllegalStateException e) {
            throw JsonBindException.rethrow(parser.getLocation(), event, Integer.class, e);
        }
    }

}
