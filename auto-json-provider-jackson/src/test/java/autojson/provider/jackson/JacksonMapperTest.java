package autojson.provider.jackson;

import autojson.integration.MapperTest;
import autojson.stream.JsonFactory;

public final class JacksonMapperTest extends MapperTest {

    public JacksonMapperTest(Object mapper, String expectedJson, String inputJson) {
        super(mapper, expectedJson, inputJson);
    }

    @Override
    protected JsonFactory factory() {
        return new JacksonFactory();
    }

}
