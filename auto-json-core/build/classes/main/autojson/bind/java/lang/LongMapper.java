package autojson.bind.java.lang;

import autojson.bind.NullableMapper;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import javax.annotation.Generated;

@Generated("autojson.internal.bind.DefaultsProcessor")
public final class LongMapper extends NullableMapper<Long> {

    @Override
    protected Long readNotNull(JsonParser parser) throws java.io.IOException {
        return parser.getLong();
    }

    @Override
    protected void writeNotNull(JsonGenerator generator, Long value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
