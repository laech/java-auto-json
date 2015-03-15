package autojson.provider.jackson;

import autojson.bind.MapperTest;
import autojson.stream.JsonFactory;

public final class JacksonMapperTest extends MapperTest {

    public <T> JacksonMapperTest(Object mapper, T expected) {
        super(mapper, expected);
    }

    @Override
    protected JsonFactory factory() {
        return new JacksonFactory();
    }

}
