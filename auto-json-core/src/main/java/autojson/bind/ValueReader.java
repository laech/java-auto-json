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
     * Reads the next object from the current parser position.
     * <p/>
     * If the next token is
     * <ul>
     * <li>{@link JsonToken#NULL NULL} - will return null</li>
     * <li>{@link JsonToken#BEGIN_OBJECT BEGIN_OBJECT} - will parse the object</li>
     * <li>else - will throw {@link IllegalStateException}</li>
     * </ul>
     */
    @Nullable
    T read(JsonParser parser) throws IOException;

}
