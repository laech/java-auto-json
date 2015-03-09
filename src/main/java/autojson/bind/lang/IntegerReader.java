package autojson.bind.lang;

import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public final class IntegerReader extends NullableValueReader<Integer> {

    @Override
    protected Integer read(JsonParser parser, Event event) {
        return parser.getInt();
    }

}
