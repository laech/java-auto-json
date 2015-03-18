package autojson.provider.jackson;

import autojson.bind.Mapper;
import autojson.integration.AutoJsonMapperTest;
import autojson.stream.JsonFactory;

public final class JacksonAutoJsonMapperTest extends AutoJsonMapperTest {

    public JacksonAutoJsonMapperTest(Mapper<Object> mapper, Object expected, String json) {
        super(mapper, expected, json);
    }

    @Override
    protected JsonFactory factory() {
        return new JacksonFactory();
    }

}
