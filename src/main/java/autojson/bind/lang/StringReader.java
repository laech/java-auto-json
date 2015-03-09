package autojson.bind.lang;

import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class StringReader extends NullableValueReader<String> {

    @Override
    protected String read(JsonParser parser, Event event) {
        return parser.getString();
    }

}
