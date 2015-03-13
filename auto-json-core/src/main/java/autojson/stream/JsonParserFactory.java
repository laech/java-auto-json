package autojson.stream;

import java.io.IOException;
import java.io.Reader;

public interface JsonParserFactory {

    JsonParser createParser(Reader reader) throws IOException;

}
