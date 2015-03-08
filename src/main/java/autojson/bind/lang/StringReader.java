package autojson.bind.lang;

import autojson.bind.JsonBindException;
import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class StringReader extends NullableValueReader<String> {

    public static final StringReader INSTANCE = new StringReader();

    @Override
    protected String read(JsonParser parser, Event event) {
        try {
            return parser.getString();
        } catch (IllegalStateException e) {
            throw JsonBindException.rethrow(parser.getLocation(), event, String.class, e);
        }
    }

}
