package autojson.provider.jackson;

import autojson.integration.ParsingTester;
import org.junit.Test;

public final class ParsingTest {

    @Test
    public void parsing() throws Exception {
        new ParsingTester().test(new JacksonParserFactory());
    }

}
