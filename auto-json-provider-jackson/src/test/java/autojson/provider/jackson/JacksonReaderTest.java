package autojson.provider.jackson;

import autojson.bind.ValueReader;
import autojson.integration.ReaderTest;
import autojson.stream.JsonFactory;

public final class JacksonReaderTest extends ReaderTest {

    public JacksonReaderTest(ValueReader<Object> reader, Object expected, String json) {
        super(reader, expected, json);
    }

    @Override
    protected JsonFactory factory() {
        return new JacksonFactory();
    }

}
