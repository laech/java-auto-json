package autojson.bind;

import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import java.io.IOException;

public abstract class NullableMapper<T> implements ValueMapper<T> {

    @Override
    public final T read(JsonParser parser) throws IOException {
        if (!parser.next()) {
            throw new JsonBindException("No more token from parser");
        }
        if (parser.getToken() == JsonToken.NULL) {
            return null;
        }
        return readNotNull(parser);
    }

    protected abstract T readNotNull(JsonParser parser) throws IOException;

    @Override
    public final void write(JsonGenerator generator, T value) throws IOException {
        if (value == null) {
            generator.writeNull();
        } else {
            writeNotNull(generator, value);
        }
    }

    protected abstract void writeNotNull(JsonGenerator generator, T value) throws IOException;

}
