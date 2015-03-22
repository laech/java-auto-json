package autojson.integration;

import autojson.bind.Mapper;
import autojson.integration.sub.AutoJson_CrossPackageObject;
import autojson.integration.sub.CrossPackageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public abstract class AutoJsonMapperTest extends MapperTest {

    @Parameters(name = "{1}")
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
                {new AutoJson_ObjectBigDecimal(), new AutoValue_ObjectBigDecimal(new BigDecimal("1E+10")), "{\"value\":1E+10}"},
                {new AutoJson_ObjectBigDecimal(), new AutoValue_ObjectBigDecimal(new BigDecimal("1E+100")), "{\"value\":1E+100}"},

                {new AutoJson_ObjectNestedAutoJson(), new AutoValue_ObjectNestedAutoJson(null), "{\"value\":null}"},
                {new AutoJson_ObjectNestedAutoJson(), new AutoValue_ObjectNestedAutoJson(new AutoValue_ObjectString("a")), "{\"value\":{\"value\":\"a\"}}"},
                {
                        new AutoJson_ObjectNestedAutoJsonMulti(),
                        new AutoValue_ObjectNestedAutoJsonMulti(
                                new AutoValue_ObjectString("a"),
                                new AutoValue_PrimitiveInt(1),
                                100L
                        ), "" +
                        "{" +
                        "\"stringValue\":{\"value\":\"a\"}," +
                        "\"intValue\":{\"value\":1}," +
                        "\"longValue\":100" +
                        "}"
                },

                {new AutoJson_ObjectEmpty(), new AutoValue_ObjectEmpty(), "{}"},
                {new AutoJson_ObjectStaticInnerClass_Inner(), new AutoValue_ObjectStaticInnerClass_Inner("hello world"), "{\"value\":\"hello world\"}"},
                {new AutoJson_CrossPackageObject(), CrossPackageObject.create(101), "{\"value\":101}"},
                {new AutoJson_ObjectNameWithSpace(), new AutoValue_ObjectNameWithSpace("a"), "{\"key with spaces\":\"a\"}"},

                {
                        // Example from https://tools.ietf.org/html/rfc7159
                        new AutoJson_ObjectImage(),
                        new AutoValue_ObjectImage(new AutoValue_ObjectImage_Image(800, 600, "View from 15th Floor",
                                new AutoValue_ObjectImage_Thumbnail("http://www.example.com/image/481989943", 125, 100),
                                false, asList(116, 943, 234, 38793))
                        ), "" +
                        "{" +
                        "\"Image\":{" +
                        "\"Width\":800," +
                        "\"Height\":600," +
                        "\"Title\":\"View from 15th Floor\"," +
                        "\"Thumbnail\":{" +
                        "\"Url\":\"http://www.example.com/image/481989943\"," +
                        "\"Height\":125," +
                        "\"Width\":100" +
                        "}," +
                        "\"Animated\":false," +
                        "\"IDs\":[116,943,234,38793]" +
                        "}" +
                        "}"
                },

                {
                        new AutoJson_ObjectListObject(),
                        new AutoValue_ObjectListObject(Arrays.<ObjectString>asList(
                                new AutoValue_ObjectString("a"),
                                new AutoValue_ObjectString("b"))
                        ), "" +
                        "{" +
                        "\"values\":[" +
                        "{\"value\":\"a\"}," +
                        "{\"value\":\"b\"}" +
                        "]" +
                        "}"
                },

                {
                        new AutoJson_ObjectSetObject(),
                        new AutoValue_ObjectSetObject(new HashSet<ObjectInt>() {{
                            add(new AutoValue_ObjectInt(1));
                            add(new AutoValue_ObjectInt(2));
                        }}), "" +
                        "{" +
                        "\"values\":[" +
                        "{\"value\":1}," +
                        "{\"value\":2}" +
                        "]" +
                        "}"
                },

                {
                        new AutoJson_ObjectListSetObject(),
                        new AutoValue_ObjectListSetObject(Arrays.<Set<ObjectInt>>asList(
                                new HashSet<ObjectInt>() {{
                                    add(new AutoValue_ObjectInt(1));
                                    add(new AutoValue_ObjectInt(2));
                                }},
                                new HashSet<ObjectInt>() {{
                                    add(new AutoValue_ObjectInt(3));
                                }}
                        )
                        ), "" +
                        "{" +
                        "\"values\":[" +
                        "[" +
                        "{\"value\":1}," +
                        "{\"value\":2}" +
                        "]," +
                        "[" +
                        "{\"value\":3}" +
                        "]" +
                        "]" +
                        "}"
                },

                {
                        new AutoJson_ObjectListListListInt(),
                        new AutoValue_ObjectListListListInt(asList(
                                asList(asList(1, 2)),
                                asList(asList(3)),
                                asList(asList(4))
                        )), "" +
                        "{" +
                        "\"values\":[" +
                        "[[1,2]]," +
                        "[[3]]," +
                        "[[4]]" +
                        "]" +
                        "}"
                },

        });
    }

    public AutoJsonMapperTest(Mapper<Object> mapper, Object object, String json) {
        super(mapper, object, json);
    }

}
