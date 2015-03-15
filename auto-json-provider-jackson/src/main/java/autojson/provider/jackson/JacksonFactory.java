package autojson.provider.jackson;

import autojson.stream.JsonGenerator;
import autojson.stream.JsonParseException;
import autojson.stream.JsonParser;
import autojson.stream.JsonFactory;
import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

@AutoService(JsonFactory.class)
public final class JacksonFactory implements JsonFactory {

    private final com.fasterxml.jackson.core.JsonFactory delegate = new com.fasterxml.jackson.core.JsonFactory();

    @Override
    public JsonParser createParser(Reader reader) throws IOException {
        try {
            return new JacksonParser(delegate.createParser(reader));
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public JsonGenerator createGenerator(Writer writer) throws IOException {
        return new JacksonGenerator(delegate.createGenerator(writer));
    }

}
