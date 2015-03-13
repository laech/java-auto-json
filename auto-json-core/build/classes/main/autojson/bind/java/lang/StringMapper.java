package autojson.bind.java.lang;

import autojson.bind.NullableMapper;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import javax.annotation.Generated;

@Generated("autojson.internal.bind.DefaultsProcessor")
public final class StringMapper extends NullableMapper<String> {

    @Override
    protected String readNotNull(JsonParser parser) throws java.io.IOException {
        return parser.getString();
    }

    @Override
    protected void writeNotNull(JsonGenerator generator, String value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
