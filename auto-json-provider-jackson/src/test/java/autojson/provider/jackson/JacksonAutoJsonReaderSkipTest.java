package autojson.provider.jackson;

import autojson.bind.Mapper;
import autojson.integration.AutoJsonReaderSkipTest;
import autojson.stream.JsonFactory;

public final class JacksonAutoJsonReaderSkipTest extends AutoJsonReaderSkipTest {

    public JacksonAutoJsonReaderSkipTest(Mapper<Object> mapper, Object object, String json) {
        super(mapper, object, json);
    }

    @Override
    protected JsonFactory factory() {
        return new JacksonFactory();
    }

}
