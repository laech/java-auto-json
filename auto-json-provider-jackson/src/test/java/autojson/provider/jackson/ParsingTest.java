package autojson.provider.jackson;

import autojson.integration.ParseTester;
import org.junit.Test;

public final class ParsingTest {

    @Test
    public void parsing() throws Exception {
        new ParseTester().test(new JacksonParserFactory());
    }

}
