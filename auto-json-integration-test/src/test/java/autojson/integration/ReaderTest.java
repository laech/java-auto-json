package autojson.integration;

import autojson.bind.ValueReader;
import autojson.integration.sub.AutoJson_CrossPackageObject;
import autojson.integration.sub.CrossPackageObject;
import autojson.stream.JsonFactory;
import autojson.stream.JsonParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Collection;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public abstract class ReaderTest {

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {new AutoJson_PrimitiveInt(), new AutoValue_PrimitiveInt(0), "{\"value\":0}"},
                {new AutoJson_PrimitiveInt(), new AutoValue_PrimitiveInt(Integer.MAX_VALUE), "{\"value\":" + Integer.MAX_VALUE + "}"},
                {new AutoJson_PrimitiveInt(), new AutoValue_PrimitiveInt(Integer.MIN_VALUE), "{\"value\":" + Integer.MIN_VALUE + "}"},

                {new AutoJson_ObjectInt(), new AutoValue_ObjectInt(null), "{\"value\":null}"},
                {new AutoJson_ObjectInt(), new AutoValue_ObjectInt(0), "{\"value\":0}"},
                {new AutoJson_ObjectInt(), new AutoValue_ObjectInt(Integer.MAX_VALUE), "{\"value\":" + Integer.MAX_VALUE + "}"},
                {new AutoJson_ObjectInt(), new AutoValue_ObjectInt(Integer.MIN_VALUE), "{\"value\":" + Integer.MIN_VALUE + "}"},

                {new AutoJson_PrimitiveLong(), new AutoValue_PrimitiveLong(0), "{\"value\":0}"},
                {new AutoJson_PrimitiveLong(), new AutoValue_PrimitiveLong(Long.MAX_VALUE), "{\"value\":" + Long.MAX_VALUE + "}"},
                {new AutoJson_PrimitiveLong(), new AutoValue_PrimitiveLong(Long.MIN_VALUE), "{\"value\":" + Long.MIN_VALUE + "}"},

                {new AutoJson_ObjectLong(), new AutoValue_ObjectLong(null), "{\"value\":null}"},
                {new AutoJson_ObjectLong(), new AutoValue_ObjectLong(0L), "{\"value\":0}"},
                {new AutoJson_ObjectLong(), new AutoValue_ObjectLong(Long.MAX_VALUE), "{\"value\":" + Long.MAX_VALUE + "}"},
                {new AutoJson_ObjectLong(), new AutoValue_ObjectLong(Long.MIN_VALUE), "{\"value\":" + Long.MIN_VALUE + "}"},

                {new AutoJson_PrimitiveBoolean(), new AutoValue_PrimitiveBoolean(false), "{\"value\":false}"},
                {new AutoJson_PrimitiveBoolean(), new AutoValue_PrimitiveBoolean(true), "{\"value\":true}"},

                {new AutoJson_ObjectBoolean(), new AutoValue_ObjectBoolean(null), "{\"value\":null}"},
                {new AutoJson_ObjectBoolean(), new AutoValue_ObjectBoolean(false), "{\"value\":false}"},
                {new AutoJson_ObjectBoolean(), new AutoValue_ObjectBoolean(true), "{\"value\":true}"},

                {new AutoJson_ObjectString(), new AutoValue_ObjectString(""), "{\"value\":\"\"}"},
                {new AutoJson_ObjectString(), new AutoValue_ObjectString("hello"), "{\"value\":\"hello\"}"},
                {new AutoJson_ObjectString(), new AutoValue_ObjectString(null), "{\"value\":null}"},

                {new AutoJson_ObjectBigDecimal(), new AutoValue_ObjectBigDecimal(new BigDecimal("0")), "{\"value\":0}"},
                {new AutoJson_ObjectBigDecimal(), new AutoValue_ObjectBigDecimal(new BigDecimal("9.9")), "{\"value\":9.9}"},
                {new AutoJson_ObjectBigDecimal(), new AutoValue_ObjectBigDecimal(new BigDecimal("-0.3")), "{\"value\":-0.3}"},
                {new AutoJson_ObjectBigDecimal(), new AutoValue_ObjectBigDecimal(new BigDecimal("1e10")), "{\"value\":1e10}"},
                {new AutoJson_ObjectBigDecimal(), new AutoValue_ObjectBigDecimal(new BigDecimal("1e100")), "{\"value\":1e100}"},

                {new AutoJson_ObjectNestedAutoJson(), new AutoValue_ObjectNestedAutoJson(null), "{\"value\":null}"},
                {new AutoJson_ObjectNestedAutoJson(), new AutoValue_ObjectNestedAutoJson(new AutoValue_ObjectString("a")), "{\"value\":{\"value\":\"a\"}}"},
                {
                        new AutoJson_ObjectNestedAutoJsonMulti(),
                        new AutoValue_ObjectNestedAutoJsonMulti(
                                new AutoValue_ObjectString("a"),
                                new AutoValue_PrimitiveInt(1),
                                100L
                        ), "" +
                        "\n{" +
                        "\n  \"stringValue\": {" +
                        "\n      \"value\": \"a\"" +
                        "\n  }," +
                        "\n  \"intValue\": {" +
                        "\n      \"value\": 1" +
                        "\n  }," +
                        "\n  \"longValue\": 100" +
                        "\n}"
                },

                {new AutoJson_ObjectEmpty(), new AutoValue_ObjectEmpty(), "{}"},
                {new AutoJson_ObjectStaticInnerClass_Inner(), new AutoValue_ObjectStaticInnerClass_Inner("hello world"), "{\"value\":\"hello world\"}"},
                {new AutoJson_CrossPackageObject(), CrossPackageObject.create(101), "{\"value\":101}"},

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

    private final Object expected;
    private final ValueReader<Object> reader;
    private final String json;

    public ReaderTest(ValueReader<Object> reader, Object expected, String json) {
        this.expected = expected;
        this.reader = reader;
        this.json = json;
    }

    @Test
    public void test() throws Exception {
        JsonParser parser = factory().createParser(new StringReader(json));
        assertThat(reader.read(parser)).isEqualTo(expected);
    }

    protected abstract JsonFactory factory();

}
