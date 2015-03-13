package autojson.bind.java.lang;

import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import javax.annotation.Generated;

@Generated("autojson.internal.bind.DefaultsProcessor")
public final class PrimitiveLongMapper {

    public long read(JsonParser parser) throws java.io.IOException {
        if (!parser.next()) {
            throw new autojson.bind.JsonBindException("No more token from parser");
        }
        return parser.getLong();
    }

    public void write(JsonGenerator generator, long value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
