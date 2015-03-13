package autojson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface JsonGenerator extends Flushable, Closeable {

    void writeBeginObject() throws IOException;

    void writeEndObject() throws IOException;

    void writeBeginArray() throws IOException;

    void writeEndArray() throws IOException;

    void writeName(String name) throws IOException;

    void writeValue(boolean value) throws IOException;

    void writeValue(int value) throws IOException;

    void writeValue(long value) throws IOException;

    void writeValue(String value) throws IOException;

    void writeValue(Number value) throws IOException;

    void writeNull() throws IOException;

}
