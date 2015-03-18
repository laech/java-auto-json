package autojson.bind;

import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import java.io.IOException;

import static autojson.stream.JsonToken.NULL;

/**
 * Base mapper performs simple book keeping and null checks.
 */
public abstract class NullableMapper<T> implements Mapper<T> {

    @Override
    public T read(JsonParser parser) throws IOException {
        if (!parser.next()) {
            throw new IllegalStateException("No more token from parser");
        }
        return readCurrent(parser);
    }

    @Override
    public T readCurrent(JsonParser parser) throws IOException {
        if (parser.getToken() == NULL) {
            return null;
        }
        return readNotNull(parser);
    }

    /**
     * Reads a result by reading from the current token, the token has been
     * checked and it's not {@link JsonToken#NULL}.
     */
    protected abstract T readNotNull(JsonParser parser) throws IOException;

    @Override
    public void write(JsonGenerator generator, T value) throws IOException {
        if (value == null) {
            generator.writeNull();
        } else {
            writeNotNull(generator, value);
        }
    }

    /**
     * Writes the given non-null value to JSON.
     */
    protected abstract void writeNotNull(JsonGenerator generator, T value) throws IOException;

}
