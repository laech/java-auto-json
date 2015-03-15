package autojson.stream;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public interface JsonFactory {

    JsonParser createParser(Reader reader) throws IOException;

    JsonGenerator createGenerator(Writer writer) throws IOException;

}
