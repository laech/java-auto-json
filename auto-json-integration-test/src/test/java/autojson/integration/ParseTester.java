package autojson.integration;

import autojson.bind.ValueReader;
import autojson.integration.sub.AutoJson_CrossPackageObject;
import autojson.integration.sub.CrossPackageObject;
import autojson.stream.JsonParser;
import autojson.stream.JsonParserFactory;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Arrays.asList;
import static java.util.logging.Level.INFO;
import static org.junit.Assert.assertEquals;

public final class ParseTester {

    private final List<Scenario> scenarios;

    public ParseTester() {
        scenarios = asList(
                new Scenario(new AutoValue_PrimitiveInt(0), new AutoJson_PrimitiveInt(), "{\"value\":0}"),
                new Scenario(new AutoValue_PrimitiveInt(Integer.MAX_VALUE), new AutoJson_PrimitiveInt(), "{\"value\":" + Integer.MAX_VALUE + "}"),
                new Scenario(new AutoValue_PrimitiveInt(Integer.MIN_VALUE), new AutoJson_PrimitiveInt(), "{\"value\":" + Integer.MIN_VALUE + "}"),

                new Scenario(new AutoValue_ObjectInt(null), new AutoJson_ObjectInt(), "{\"value\":null}"),
                new Scenario(new AutoValue_ObjectInt(0), new AutoJson_ObjectInt(), "{\"value\":0}"),
                new Scenario(new AutoValue_ObjectInt(Integer.MAX_VALUE), new AutoJson_ObjectInt(), "{\"value\":" + Integer.MAX_VALUE + "}"),
                new Scenario(new AutoValue_ObjectInt(Integer.MIN_VALUE), new AutoJson_ObjectInt(), "{\"value\":" + Integer.MIN_VALUE + "}"),

                new Scenario(new AutoValue_PrimitiveLong(0), new AutoJson_PrimitiveLong(), "{\"value\":0}"),
                new Scenario(new AutoValue_PrimitiveLong(Long.MAX_VALUE), new AutoJson_PrimitiveLong(), "{\"value\":" + Long.MAX_VALUE + "}"),
                new Scenario(new AutoValue_PrimitiveLong(Long.MIN_VALUE), new AutoJson_PrimitiveLong(), "{\"value\":" + Long.MIN_VALUE + "}"),

                new Scenario(new AutoValue_ObjectLong(null), new AutoJson_ObjectLong(), "{\"value\":null}"),
                new Scenario(new AutoValue_ObjectLong(0L), new AutoJson_ObjectLong(), "{\"value\":0}"),
                new Scenario(new AutoValue_ObjectLong(Long.MAX_VALUE), new AutoJson_ObjectLong(), "{\"value\":" + Long.MAX_VALUE + "}"),
                new Scenario(new AutoValue_ObjectLong(Long.MIN_VALUE), new AutoJson_ObjectLong(), "{\"value\":" + Long.MIN_VALUE + "}"),

                new Scenario(new AutoValue_PrimitiveBoolean(false), new AutoJson_PrimitiveBoolean(), "{\"value\":false}"),
                new Scenario(new AutoValue_PrimitiveBoolean(true), new AutoJson_PrimitiveBoolean(), "{\"value\":true}"),

                new Scenario(new AutoValue_ObjectBoolean(null), new AutoJson_ObjectBoolean(), "{\"value\":null}"),
                new Scenario(new AutoValue_ObjectBoolean(false), new AutoJson_ObjectBoolean(), "{\"value\":false}"),
                new Scenario(new AutoValue_ObjectBoolean(true), new AutoJson_ObjectBoolean(), "{\"value\":true}"),

                new Scenario(new AutoValue_ObjectString(""), new AutoJson_ObjectString(), "{\"value\":\"\"}"),
                new Scenario(new AutoValue_ObjectString("hello"), new AutoJson_ObjectString(), "{\"value\":\"hello\"}"),
                new Scenario(new AutoValue_ObjectString(null), new AutoJson_ObjectString(), "{\"value\":null}"),

                new Scenario(new AutoValue_ObjectBigDecimal(new BigDecimal("0")), new AutoJson_ObjectBigDecimal(), "{\"value\":0}"),
                new Scenario(new AutoValue_ObjectBigDecimal(new BigDecimal("9.9")), new AutoJson_ObjectBigDecimal(), "{\"value\":9.9}"),
                new Scenario(new AutoValue_ObjectBigDecimal(new BigDecimal("-0.3")), new AutoJson_ObjectBigDecimal(), "{\"value\":-0.3}"),
                new Scenario(new AutoValue_ObjectBigDecimal(new BigDecimal("1e10")), new AutoJson_ObjectBigDecimal(), "{\"value\":1e10}"),
                new Scenario(new AutoValue_ObjectBigDecimal(new BigDecimal("1e100")), new AutoJson_ObjectBigDecimal(), "{\"value\":1e100}"),

                new Scenario(new AutoValue_ObjectNestedAutoJson(null), new AutoJson_ObjectNestedAutoJson(), "{\"value\":null}"),
                new Scenario(new AutoValue_ObjectNestedAutoJson(new AutoValue_ObjectString("a")), new AutoJson_ObjectNestedAutoJson(), "{\"value\":{\"value\":\"a\"}}"),

                new Scenario(
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
                ),

                new Scenario(new AutoValue_ObjectEmpty(), new AutoJson_ObjectEmpty(), "{}"),
                new Scenario(new AutoValue_ObjectStaticInnerClass_Inner("hello world"), new AutoJson_ObjectStaticInnerClass_Inner(), "{\"value\":\"hello world\"}"),
                new Scenario(CrossPackageObject.create(101), new AutoJson_CrossPackageObject(), "{\"value\":101}"),


                new Scenario(
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
                        "\n    \"valueY\": {" +
                        "\n      \"value1\": 1," +
                        "\n      \"value2\": {" +
                        "\n        \"value2.1\": 2.1" +
                        "\n      }," +
                        "\n      \"value3\": 3" +
                        "\n    }" +
                        "\n  }" +
                        "\n}"
                ));
    }

    public void test(JsonParserFactory factory) throws Exception {
        Logger logger = Logger.getLogger(getClass().getCanonicalName());
        for (Scenario scenario : scenarios) {
            JsonParser parser = factory.createParser(new StringReader(scenario.json));
            Object actual = scenario.reader.read(parser);
            if (logger.isLoggable(INFO)) {
                logger.info("Testing " + factory +
                                "\nExpected: " + scenario.expected +
                                "\n  Actual: " + actual +
                                "\n    Json: " + scenario.json +
                                "\n"
                );
            }
            assertEquals(scenario.expected, actual);
        }
    }

    private static final class Scenario {
        final Object expected;
        final ValueReader<Object> reader;
        final String json;

        @SuppressWarnings("unchecked")
        private <T> Scenario(T expected, ValueReader<T> reader, String json) {
            this.expected = expected;
            this.reader = (ValueReader<Object>) reader;
            this.json = json;
        }
    }

}
