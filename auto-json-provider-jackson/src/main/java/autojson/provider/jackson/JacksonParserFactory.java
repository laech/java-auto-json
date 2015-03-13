package autojson.provider.jackson;

import autojson.stream.JsonParseException;
import autojson.stream.JsonParser;
import autojson.stream.JsonParserFactory;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Reader;

@AutoService(JsonParserFactory.class)
public final class JacksonParserFactory implements JsonParserFactory {

    private final JsonFactory delegate = new JsonFactory();

    @Override
    public JsonParser createParser(Reader reader) throws IOException {
        try {
            return new JacksonParser(delegate.createParser(reader));
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            throw new JsonParseException(e);
        }
    }

}
