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

                {new AutoValue_PrimitiveInt(0), AutoJson_PrimitiveInt.INSTANCE, "{\"value\":0}"},
                {new AutoValue_PrimitiveInt(Integer.MAX_VALUE), AutoJson_PrimitiveInt.INSTANCE, "{\"value\":" + Integer.MAX_VALUE + "}"},
                {new AutoValue_PrimitiveInt(Integer.MIN_VALUE), AutoJson_PrimitiveInt.INSTANCE, "{\"value\":" + Integer.MIN_VALUE + "}"},

                {new AutoValue_ObjectInt(null), AutoJson_ObjectInt.INSTANCE, "{\"value\":null}"},
                {new AutoValue_ObjectInt(0), AutoJson_ObjectInt.INSTANCE, "{\"value\":0}"},
                {new AutoValue_ObjectInt(Integer.MAX_VALUE), AutoJson_ObjectInt.INSTANCE, "{\"value\":" + Integer.MAX_VALUE + "}"},
                {new AutoValue_ObjectInt(Integer.MIN_VALUE), AutoJson_ObjectInt.INSTANCE, "{\"value\":" + Integer.MIN_VALUE + "}"},

                {new AutoValue_PrimitiveLong(0), AutoJson_PrimitiveLong.INSTANCE, "{\"value\":0}"},
                {new AutoValue_PrimitiveLong(Long.MAX_VALUE), AutoJson_PrimitiveLong.INSTANCE, "{\"value\":" + Long.MAX_VALUE + "}"},
                {new AutoValue_PrimitiveLong(Long.MIN_VALUE), AutoJson_PrimitiveLong.INSTANCE, "{\"value\":" + Long.MIN_VALUE + "}"},

                {new AutoValue_ObjectLong(null), AutoJson_ObjectLong.INSTANCE, "{\"value\":null}"},
                {new AutoValue_ObjectLong(0L), AutoJson_ObjectLong.INSTANCE, "{\"value\":0}"},
                {new AutoValue_ObjectLong(Long.MAX_VALUE), AutoJson_ObjectLong.INSTANCE, "{\"value\":" + Long.MAX_VALUE + "}"},
                {new AutoValue_ObjectLong(Long.MIN_VALUE), AutoJson_ObjectLong.INSTANCE, "{\"value\":" + Long.MIN_VALUE + "}"},

                {new AutoValue_PrimitiveBoolean(false), AutoJson_PrimitiveBoolean.INSTANCE, "{\"value\":false}"},
                {new AutoValue_PrimitiveBoolean(true), AutoJson_PrimitiveBoolean.INSTANCE, "{\"value\":true}"},

                {new AutoValue_ObjectBoolean(null), AutoJson_ObjectBoolean.INSTANCE, "{\"value\":null}"},
                {new AutoValue_ObjectBoolean(false), AutoJson_ObjectBoolean.INSTANCE, "{\"value\":false}"},
                {new AutoValue_ObjectBoolean(true), AutoJson_ObjectBoolean.INSTANCE, "{\"value\":true}"},

                {new AutoValue_ObjectString(""), AutoJson_ObjectString.INSTANCE, "{\"value\":\"\"}"},
                {new AutoValue_ObjectString("hello"), AutoJson_ObjectString.INSTANCE, "{\"value\":\"hello\"}"},
                {new AutoValue_ObjectString(null), AutoJson_ObjectString.INSTANCE, "{\"value\":null}"},

                {new AutoValue_ObjectBigDecimal(new BigDecimal("0")), AutoJson_ObjectBigDecimal.INSTANCE, "{\"value\":0}"},
                {new AutoValue_ObjectBigDecimal(new BigDecimal("9.9")), AutoJson_ObjectBigDecimal.INSTANCE, "{\"value\":9.9}"},
                {new AutoValue_ObjectBigDecimal(new BigDecimal("-0.3")), AutoJson_ObjectBigDecimal.INSTANCE, "{\"value\":-0.3}"},
                {new AutoValue_ObjectBigDecimal(new BigDecimal("1e10")), AutoJson_ObjectBigDecimal.INSTANCE, "{\"value\":1e10}"},
                {new AutoValue_ObjectBigDecimal(new BigDecimal("1e100")), AutoJson_ObjectBigDecimal.INSTANCE, "{\"value\":1e100}"},

                {new AutoValue_ObjectNestedAutoJson(null), AutoJson_ObjectNestedAutoJson.INSTANCE, "{\"value\":null}"},
                {new AutoValue_ObjectNestedAutoJson(new AutoValue_ObjectString("a")), AutoJson_ObjectNestedAutoJson.INSTANCE, "{\"value\":{\"value\":\"a\"}}"},

                {
                        new AutoValue_ObjectNestedAutoJsonMulti(
                                new AutoValue_ObjectString("a"),
                                new AutoValue_PrimitiveInt(1),
                                100L
                        ),
                        AutoJson_ObjectNestedAutoJsonMulti.INSTANCE, "" +
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

                {new AutoValue_ObjectEmpty(), AutoJson_ObjectEmpty.INSTANCE, "{}"},
                {new AutoValue_ObjectStaticInnerClass_Inner("hello world"), AutoJson_ObjectStaticInnerClass_Inner.INSTANCE, "{\"value\":\"hello world\"}"},
                {CrossPackageObject.create(101), AutoJson_CrossPackageObject.INSTANCE, "{\"value\":101}"},


                {
                        new AutoValue_ObjectString("skip unknowns"),
                        AutoJson_ObjectString.INSTANCE, "" +
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
