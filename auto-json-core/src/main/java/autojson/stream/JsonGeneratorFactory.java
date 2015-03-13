package autojson.stream;

import java.io.IOException;
import java.io.Writer;

public interface JsonGeneratorFactory {

    JsonGenerator createGenerator(Writer writer) throws IOException;

}
