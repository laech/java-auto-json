package autojson.bind.lang;

import autojson.bind.JsonBindException;

import javax.json.stream.JsonParser;

public final class PrimitiveLongReader {

    public static final PrimitiveLongReader INSTANCE = new PrimitiveLongReader();

    public long read(JsonParser parser) {
        JsonParser.Event event = parser.next();
        try {
            return parser.getLong();
        } catch (IllegalStateException e) {
            throw JsonBindException.rethrow(parser.getLocation(), event, "long", e);
        }
    }

}
