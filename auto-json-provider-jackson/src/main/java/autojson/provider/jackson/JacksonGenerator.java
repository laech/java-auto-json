package autojson.provider.jackson;


import autojson.stream.JsonGenerateException;
import autojson.stream.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public final class JacksonGenerator implements JsonGenerator {

    private final com.fasterxml.jackson.core.JsonGenerator delegate;

    public JacksonGenerator(com.fasterxml.jackson.core.JsonGenerator delegate) {
        if (delegate == null) {
            throw new NullPointerException();
        }
        this.delegate = delegate;
    }

    @Override
    public void writeBeginObject() throws IOException {
        try {
            delegate.writeStartObject();
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeEndObject() throws IOException {
        try {
            delegate.writeEndObject();
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeBeginArray() throws IOException {
        try {
            delegate.writeStartArray();
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeEndArray() throws IOException {
        try {
            delegate.writeEndArray();
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeName(String name) throws IOException {
        try {
            delegate.writeFieldName(name);
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeValue(boolean value) throws IOException {
        try {
            delegate.writeBoolean(value);
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeValue(int value) throws IOException {
        try {
            delegate.writeNumber(value);
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeValue(long value) throws IOException {
        try {
            delegate.writeNumber(value);
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeValue(String value) throws IOException {
        try {
            delegate.writeString(value);
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeValue(Number value) throws IOException {
        try {
            String string = value.toString();
            if (string.equals("NaN") || string.equals("Infinity") || string.equals("-Infinity")) {
                throw new JsonGenerateException("Number must be finite: " + string);
            }
            delegate.writeNumber(string);
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void writeNull() throws IOException {
        try {
            delegate.writeNull();
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void flush() throws IOException {
        try {
            delegate.flush();
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }

    @Override
    public void close() throws IOException {
        try {
            delegate.close();
        } catch (JsonProcessingException e) {
            throw new JsonGenerateException(e);
        }
    }
}
