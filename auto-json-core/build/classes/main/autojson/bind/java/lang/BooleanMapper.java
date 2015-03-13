package autojson.bind.java.lang;

import autojson.bind.NullableMapper;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import javax.annotation.Generated;

@Generated("autojson.internal.bind.DefaultsProcessor")
public final class BooleanMapper extends NullableMapper<Boolean> {

    @Override
    protected Boolean readNotNull(JsonParser parser) throws java.io.IOException {
        return parser.getBoolean();
    }

    @Override
    protected void writeNotNull(JsonGenerator generator, Boolean value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
