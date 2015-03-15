package autojson.bind;

import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import javax.annotation.Nullable;
import java.io.IOException;

/**
 * Reads an object from JSON.
 *
 * @param <T> the object type can be read by this reader
 */
public interface ValueReader<T> {

    /**
     * Reads the next value from the current parser position.
     *
     * @return the value read, or null if the value is {@link JsonToken#NULL}
     * @throws JsonBindException if the next value type cannot be handled by this instance
     */
    @Nullable
    T read(JsonParser parser) throws IOException;

}
