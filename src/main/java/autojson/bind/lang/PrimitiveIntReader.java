package autojson.bind.lang;

import autojson.bind.JsonBindException;

import javax.json.stream.JsonParser;

public final class PrimitiveIntReader {

    public static final PrimitiveIntReader INSTANCE = new PrimitiveIntReader();

    public int read(JsonParser parser) {
        JsonParser.Event event = parser.next();
        try {
            return parser.getInt();
        } catch (IllegalStateException e) {
            throw JsonBindException.rethrow(parser.getLocation(), event, "int", e);
        }
    }

}
