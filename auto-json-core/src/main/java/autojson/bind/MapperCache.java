package autojson.bind;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MapperCache {

    private static final Map<Class<?>, Object> cache = new ConcurrentHashMap<>();

    private MapperCache() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> readerClass) {
        return (T) cache.get(readerClass);
    }

    public static void put(Object reader) {
        cache.put(reader.getClass(), reader);
    }

}
