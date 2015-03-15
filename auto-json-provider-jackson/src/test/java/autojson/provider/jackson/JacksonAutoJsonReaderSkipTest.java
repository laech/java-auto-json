package autojson.provider.jackson;

import autojson.bind.ValueReader;
import autojson.integration.AutoJsonReaderSkipTest;
import autojson.stream.JsonFactory;

public final class JacksonAutoJsonReaderSkipTest extends AutoJsonReaderSkipTest {

    public JacksonAutoJsonReaderSkipTest(ValueReader<Object> reader, Object object, String json) {
        super(reader, object, json);
    }

    @Override
    protected JsonFactory factory() {
        return new JacksonFactory();
    }

}
