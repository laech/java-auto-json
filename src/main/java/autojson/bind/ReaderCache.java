package autojson.bind;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ReaderCache {

    private static final Map<Class<?>, Object> cache = new ConcurrentHashMap<>();

    private ReaderCache() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T getCachedReader(Class<T> readerClass) {
        return (T) cache.get(readerClass);
    }

    public static void putCachedReader(Object reader) {
        cache.put(reader.getClass(), reader);
    }

}
