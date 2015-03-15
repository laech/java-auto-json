package autojson.provider.jackson;

import autojson.bind.BasicMapperTest;
import autojson.stream.JsonFactory;

public final class JacksonBasicMapperTest extends BasicMapperTest {

    public <T> JacksonBasicMapperTest(Object mapper, T expected) {
        super(mapper, expected);
    }

    @Override
    protected JsonFactory factory() {
        return new JacksonFactory();
    }

}