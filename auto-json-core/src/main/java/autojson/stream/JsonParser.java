package autojson.stream;

import java.io.Closeable;
import java.io.IOException;

public interface JsonParser extends Closeable {

    boolean next() throws IOException;

    JsonToken getToken() throws IOException;

    JsonLocation getLocation() throws IOException;

    String getName() throws IOException;

    boolean getBoolean() throws IOException;

    int getInt() throws IOException;

    long getLong() throws IOException;

    String getString() throws IOException;

    void skipValue() throws IOException;

}
