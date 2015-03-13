package autojson.bind;

import autojson.stream.JsonParser;

import java.io.IOException;

public interface ValueReader<T> {

    T read(JsonParser parser) throws IOException;

}
