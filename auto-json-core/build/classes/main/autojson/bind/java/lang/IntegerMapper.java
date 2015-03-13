package autojson.bind.java.lang;

import autojson.bind.NullableMapper;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import javax.annotation.Generated;

@Generated("autojson.internal.bind.DefaultsProcessor")
public final class IntegerMapper extends NullableMapper<Integer> {

    @Override
    protected Integer readNotNull(JsonParser parser) throws java.io.IOException {
        return parser.getInt();
    }

    @Override
    protected void writeNotNull(JsonGenerator generator, Integer value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
