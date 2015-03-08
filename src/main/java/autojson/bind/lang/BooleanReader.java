package autojson.bind.lang;

import autojson.bind.JsonBindException;
import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class BooleanReader extends NullableValueReader<Boolean> {

    public static final BooleanReader INSTANCE = new BooleanReader();

    @Override
    protected Boolean read(JsonParser parser, Event event) {
        switch (event) {
            case VALUE_FALSE:
                return false;
            case VALUE_TRUE:
                return true;
            default:
                throw JsonBindException.rethrow(parser.getLocation(), event, Boolean.class, null);
        }
    }

}
