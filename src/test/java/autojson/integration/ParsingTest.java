package autojson.integration;

import autojson.bind.ValueReader;
import autojson.integration.sub.AutoJson_CrossPackageObject;
import autojson.integration.sub.CrossPackageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.json.Json;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public final class ParsingTest {

    private final Object expected;
    private final ValueReader<Object> reader;
    private final String json;

    public ParsingTest(Object expected, ValueReader<Object> reader, String json) {
        this.expected = expected;
        this.reader = reader;
        this.json = json;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{

                {new AutoValue_PrimitiveInt(0), new AutoJson_PrimitiveInt(), "{\"value\":0}"},
                {new AutoValue_PrimitiveInt(Integer.MAX_VALUE), new AutoJson_PrimitiveInt(), "{\"value\":" + Integer.MAX_VALUE + "}"},
                {new AutoValue_PrimitiveInt(Integer.MIN_VALUE), new AutoJson_PrimitiveInt(), "{\"value\":" + Integer.MIN_VALUE + "}"},

                {new AutoValue_ObjectInt(null), new AutoJson_ObjectInt(), "{\"value\":null}"},
                {new AutoValue_ObjectInt(0), new AutoJson_ObjectInt(), "{\"value\":0}"},
                {new AutoValue_ObjectInt(Integer.MAX_VALUE), new AutoJson_ObjectInt(), "{\"value\":" + Integer.MAX_VALUE + "}"},
                {new AutoValue_ObjectInt(Integer.MIN_VALUE), new AutoJson_ObjectInt(), "{\"value\":" + Integer.MIN_VALUE + "}"},

                {new AutoValue_PrimitiveLong(0), new AutoJson_PrimitiveLong(), "{\"value\":0}"},
                {new AutoValue_PrimitiveLong(Long.MAX_VALUE), new AutoJson_PrimitiveLong(), "{\"value\":" + Long.MAX_VALUE + "}"},
                {new AutoValue_PrimitiveLong(Long.MIN_VALUE), new AutoJson_PrimitiveLong(), "{\"value\":" + Long.MIN_VALUE + "}"},

                {new AutoValue_ObjectLong(null), new AutoJson_ObjectLong(), "{\"value\":null}"},
                {new AutoValue_ObjectLong(0L), new AutoJson_ObjectLong(), "{\"value\":0}"},
                {new AutoValue_ObjectLong(Long.MAX_VALUE), new AutoJson_ObjectLong(), "{\"value\":" + Long.MAX_VALUE + "}"},
                {new AutoValue_ObjectLong(Long.MIN_VALUE), new AutoJson_ObjectLong(), "{\"value\":" + Long.MIN_VALUE + "}"},

                {new AutoValue_PrimitiveBoolean(false), new AutoJson_PrimitiveBoolean(), "{\"value\":false}"},
                {new AutoValue_PrimitiveBoolean(true), new AutoJson_PrimitiveBoolean(), "{\"value\":true}"},

                {new AutoValue_ObjectBoolean(null), new AutoJson_ObjectBoolean(), "{\"value\":null}"},
                {new AutoValue_ObjectBoolean(false), new AutoJson_ObjectBoolean(), "{\"value\":false}"},
                {new AutoValue_ObjectBoolean(true), new AutoJson_ObjectBoolean(), "{\"value\":true}"},

                {new AutoValue_ObjectString(""), new AutoJson_ObjectString(), "{\"value\":\"\"}"},
                {new AutoValue_ObjectString("hello"), new AutoJson_ObjectString(), "{\"value\":\"hello\"}"},
                {new AutoValue_ObjectString(null), new AutoJson_ObjectString(), "{\"value\":null}"},

                {new AutoValue_ObjectBigDecimal(new BigDecimal("0")), new AutoJson_ObjectBigDecimal(), "{\"value\":0}"},
                {new AutoValue_ObjectBigDecimal(new BigDecimal("9.9")), new AutoJson_ObjectBigDecimal(), "{\"value\":9.9}"},
                {new AutoValue_ObjectBigDecimal(new BigDecimal("-0.3")), new AutoJson_ObjectBigDecimal(), "{\"value\":-0.3}"},
                {new AutoValue_ObjectBigDecimal(new BigDecimal("1e10")), new AutoJson_ObjectBigDecimal(), "{\"value\":1e10}"},
                {new AutoValue_ObjectBigDecimal(new BigDecimal("1e100")), new AutoJson_ObjectBigDecimal(), "{\"value\":1e100}"},

                {new AutoValue_ObjectNestedAutoJson(null), new AutoJson_ObjectNestedAutoJson(), "{\"value\":null}"},
                {new AutoValue_ObjectNestedAutoJson(new AutoValue_ObjectString("a")), new AutoJson_ObjectNestedAutoJson(), "{\"value\":{\"value\":\"a\"}}"},

                {
                        new AutoValue_ObjectNestedAutoJsonMulti(
                                new AutoValue_ObjectString("a"),
                                new AutoValue_PrimitiveInt(1),
                                100L
                        ),
                        new AutoJson_ObjectNestedAutoJsonMulti(), "" +
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

                {new AutoValue_ObjectEmpty(), new AutoJson_ObjectEmpty(), "{}"},
                {new AutoValue_ObjectStaticInnerClass_Inner("hello world"), new AutoJson_ObjectStaticInnerClass_Inner(), "{\"value\":\"hello world\"}"},
                {CrossPackageObject.create(101), new AutoJson_CrossPackageObject(), "{\"value\":101}"},


                {
                        new AutoValue_ObjectString("skip unknowns"),
                        new AutoJson_ObjectString(), "" +
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
                        "\n    \"valueY\": \"y\"" +
                        "\n  }" +
                        "\n}"
                },

        });
    }

    @Test
    public void parse() throws Exception {
        assertEquals(expected, reader.read(Json.createParser(new StringReader(json))));
    }

}
