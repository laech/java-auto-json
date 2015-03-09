package autojson.bind.lang;

import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class LongReader extends NullableValueReader<Long> {

    @Override
    protected Long read(JsonParser parser, Event event) {
        return parser.getLong();
    }

}
