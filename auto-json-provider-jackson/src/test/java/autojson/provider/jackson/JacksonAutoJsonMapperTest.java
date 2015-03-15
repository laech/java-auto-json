package autojson.provider.jackson;

import autojson.bind.ValueMapper;
import autojson.integration.AutoJsonMapperTest;
import autojson.stream.JsonFactory;

public final class JacksonAutoJsonMapperTest extends AutoJsonMapperTest {

    public JacksonAutoJsonMapperTest(ValueMapper<Object> mapper, Object expected, String json) {
        super(mapper, expected, json);
    }

    @Override
    protected JsonFactory factory() {
        return new JacksonFactory();
    }

}
