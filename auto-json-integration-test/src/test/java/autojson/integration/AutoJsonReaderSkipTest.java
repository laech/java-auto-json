package autojson.integration;

import autojson.bind.MapperTest;
import autojson.bind.ValueReader;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public abstract class AutoJsonReaderSkipTest extends MapperTest {

    @Parameters(name = "{1}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{

                {
                        new AutoJson_ObjectString(),
                        new AutoValue_ObjectString("skip unknowns"), "" +
                        "\n{" +
                        "\n  \"unknown1\": 10," +
                        "\n  \"unknown2\": {" +
                        "\n    \"value\": \"a\"" +
                        "\n  }," +
                        "\n  \"unknown3\": {" +
                        "\n    \"value\": 2" +
                        "\n  }," +
                        "\n  \"value\":\"skip unknowns\"," +
                        "\n  \"unknown4\": {" +
                        "\n    \"valueX\": \"x\"," +
                        "\n    \"valueY\": {" +
                        "\n      \"value1\": 1," +
                        "\n      \"value2\": {" +
                        "\n        \"value2.1\": 2.1" +
                        "\n      }," +
                        "\n      \"value3\": 3" +
                        "\n    }" +
                        "\n  }" +
                        "\n}"
                }

        });
    }

    public AutoJsonReaderSkipTest(ValueReader<Object> reader, Object object, String json) {
        super(reader, object, json);
    }

    @Override
    public void write() throws Exception {
        // No test for write since unknowns are ignored
    }

}
