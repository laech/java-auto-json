package autojson.bind.java.util;

import autojson.bind.Mapper;
import autojson.bind.NullableMapper;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;

import java.io.IOException;
import java.util.Collection;

import static autojson.stream.JsonToken.BEGIN_ARRAY;
import static autojson.stream.JsonToken.END_ARRAY;
import static java.util.Objects.requireNonNull;

public abstract class CollectionMapper<T, C extends Collection<T>> extends NullableMapper<C> {

    private final Mapper<T> delegate;

    protected CollectionMapper(Mapper<T> delegate) {
        this.delegate = requireNonNull(delegate);
    }

    @Override
    protected final C readNotNull(JsonParser parser) throws IOException {
        if (parser.getToken() != BEGIN_ARRAY) {
            throw new IllegalStateException("expected " + BEGIN_ARRAY + " but was "
                    + parser.getToken() + " at " + parser.getLocation());
        }
        C collection = newCollection();
        while (parser.next() && parser.getToken() != END_ARRAY) {
            collection.add(delegate.readCurrent(parser));
        }
        return collection;
    }

    protected abstract C newCollection();

    @Override
    protected final void writeNotNull(JsonGenerator generator, C values) throws IOException {
        generator.writeBeginArray();
        for (T value : values) {
            delegate.write(generator, value);
        }
        generator.writeEndArray();
    }

}
