package autojson.bind;

import autojson.stream.JsonGenerator;

import java.io.IOException;

public interface ValueWriter<T> {

    void write(JsonGenerator generator, T value) throws IOException;

}
