package autojson.provider.jackson;

import autojson.stream.JsonGenerator;
import autojson.stream.JsonGeneratorFactory;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Writer;

@AutoService(JsonGeneratorFactory.class)
public final class JacksonGeneratorFactory implements JsonGeneratorFactory {

    // TODO share with parser factory?
    private final JsonFactory factory = new JsonFactory();

    @Override
    public JsonGenerator createGenerator(Writer writer) throws IOException {
        return new JacksonGenerator(factory.createGenerator(writer));
    }

}
