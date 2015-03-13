package autojson.provider.jackson;

import autojson.stream.JsonLocation;
import autojson.stream.JsonParseException;
import autojson.stream.JsonParser;
import autojson.stream.JsonToken;

import java.io.IOException;

public final class JacksonParser implements JsonParser {

    private final com.fasterxml.jackson.core.JsonParser delegate;

    public JacksonParser(com.fasterxml.jackson.core.JsonParser delegate) {
        if (delegate == null) {
            throw new NullPointerException();
        }
        this.delegate = delegate;
    }

    @Override
    public boolean next() throws IOException {
        try {
            return delegate.nextToken() != null;
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public JsonToken getToken() {
        switch (delegate.getCurrentToken()) {
            case START_OBJECT:
                return JsonToken.BEGIN_OBJECT;
            case START_ARRAY:
                return JsonToken.BEGIN_ARRAY;
            case END_OBJECT:
                return JsonToken.END_OBJECT;
            case END_ARRAY:
                return JsonToken.END_ARRAY;
            case FIELD_NAME:
                return JsonToken.NAME;
            case VALUE_FALSE:
                return JsonToken.FALSE;
            case VALUE_TRUE:
                return JsonToken.TRUE;
            case VALUE_NULL:
                return JsonToken.NULL;
            case VALUE_NUMBER_FLOAT:
            case VALUE_NUMBER_INT:
                return JsonToken.NUMBER;
            case VALUE_STRING:
                return JsonToken.STRING;
            default:
                throw new IllegalStateException("Unexpected token " + delegate.getCurrentToken());
        }
    }

    @Override
    public JsonLocation getLocation() {
        com.fasterxml.jackson.core.JsonLocation location = delegate.getCurrentLocation();
        return JsonLocation.create(location.getLineNr(), location.getColumnNr(), location.getCharOffset());
    }

    @Override
    public String getName() throws IOException {
        try {
            String name = delegate.getCurrentName();
            if (name == null) {
                throw new JsonParseException("No name for " + getToken());
            }
            return name;
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public boolean getBoolean() throws IOException {
        try {
            return delegate.getBooleanValue();
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public int getInt() throws IOException {
        try {
            return delegate.getIntValue();
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public long getLong() throws IOException {
        try {
            return delegate.getLongValue();
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public String getString() throws IOException {
        try {
            return delegate.getValueAsString();
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public void skipValue() throws IOException {
        try {
            delegate.skipChildren();
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public void close() throws IOException {
        delegate.close();
    }

}
