package autojson.bind;

import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import java.io.IOException;
import java.util.Collection;

import static autojson.stream.JsonToken.BEGIN_ARRAY;
import static autojson.stream.JsonToken.END_ARRAY;

public final class Mappers {

    private Mappers() {
    }

    /**
     * Reads the JSON array at the current parser position into the given
     * collection, using the given mapper.
     *
     * @return the resulting collection
     * @throws IllegalStateException if {@link JsonParser#getToken()} is not
     *                               {@link JsonToken#BEGIN_ARRAY}
     */
    public static <T, C extends Collection<? super T>> C readJsonArray(Mapper<T> mapper, JsonParser parser, C collection) throws IOException {
        if (parser.getToken() != BEGIN_ARRAY) {
            throw new IllegalStateException("expected " + BEGIN_ARRAY + " but was "
                    + parser.getToken() + " at " + parser.getLocation());
        }
        while (parser.next() && parser.getToken() != END_ARRAY) {
            collection.add(mapper.readCurrent(parser));
        }
        return collection;
    }

    /**
     * Writes the given values as a JSON array using the given mapper.
     */
    public static <T> void writeJsonArray(Mapper<T> mapper, JsonGenerator generator, Iterable<? extends T> values) throws IOException {
        generator.writeBeginArray();
        for (T value : values) {
            mapper.write(generator, value);
        }
        generator.writeEndArray();
    }

}
