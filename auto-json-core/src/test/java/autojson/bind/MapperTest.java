package autojson.bind;

import autojson.bind.java.lang.BooleanMapper;
import autojson.bind.java.lang.IntegerMapper;
import autojson.bind.java.lang.LongMapper;
import autojson.bind.java.lang.PrimitiveBooleanMapper;
import autojson.bind.java.lang.PrimitiveIntMapper;
import autojson.bind.java.lang.PrimitiveLongMapper;
import autojson.bind.java.lang.StringMapper;
import autojson.bind.java.math.BigDecimalMapper;
import autojson.stream.JsonFactory;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Collection;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public abstract class MapperTest {

    @Parameterized.Parameters(name = "{1}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{

                {new BooleanMapper(), null},
                {new BooleanMapper(), TRUE},
                {new BooleanMapper(), FALSE},
                {new PrimitiveBooleanMapper(), true},
                {new PrimitiveBooleanMapper(), false},

                {new IntegerMapper(), null},
                {new IntegerMapper(), Integer.MAX_VALUE},
                {new IntegerMapper(), Integer.MIN_VALUE},
                {new IntegerMapper(), -1},
                {new IntegerMapper(), 0},
                {new IntegerMapper(), 1},
                {new IntegerMapper(), 1},
                {new PrimitiveIntMapper(), Integer.MAX_VALUE},
                {new PrimitiveIntMapper(), Integer.MIN_VALUE},
                {new PrimitiveIntMapper(), -1},
                {new PrimitiveIntMapper(), 0},
                {new PrimitiveIntMapper(), 1},
                {new PrimitiveIntMapper(), 1},

                {new LongMapper(), null},
                {new LongMapper(), Long.MAX_VALUE},
                {new LongMapper(), Long.MIN_VALUE},
                {new LongMapper(), -1L},
                {new LongMapper(), 0L},
                {new LongMapper(), 1L},
                {new PrimitiveLongMapper(), Long.MAX_VALUE},
                {new PrimitiveLongMapper(), Long.MIN_VALUE},
                {new PrimitiveLongMapper(), -1L},
                {new PrimitiveLongMapper(), 0L},
                {new PrimitiveLongMapper(), 1L},

                {new StringMapper(), null},
                {new StringMapper(), "null"},
                {new StringMapper(), ""},
                {new StringMapper(), "abc"},
                {new StringMapper(), "hello world"},

                {new BigDecimalMapper(), null},
                {new BigDecimalMapper(), new BigDecimal(Integer.MAX_VALUE)},
                {new BigDecimalMapper(), new BigDecimal(Integer.MIN_VALUE)},
                {new BigDecimalMapper(), new BigDecimal(Integer.MAX_VALUE + "1")},
                {new BigDecimalMapper(), new BigDecimal(Integer.MIN_VALUE + "1")},
                {new BigDecimalMapper(), new BigDecimal(Long.MAX_VALUE)},
                {new BigDecimalMapper(), new BigDecimal(Long.MIN_VALUE)},
                {new BigDecimalMapper(), new BigDecimal(Long.MAX_VALUE + "1")},
                {new BigDecimalMapper(), new BigDecimal(Long.MIN_VALUE + "1")},
                {new BigDecimalMapper(), new BigDecimal(Float.MAX_VALUE)},
                {new BigDecimalMapper(), new BigDecimal(Float.MIN_VALUE)},
                {new BigDecimalMapper(), new BigDecimal(Double.MAX_VALUE)},
                {new BigDecimalMapper(), new BigDecimal(Double.MIN_VALUE)},

        });
    }

    private final Object mapper;
    private final Object expected;
    private final String json;

    public <T> MapperTest(Object mapper, T expected) {
        this.mapper = mapper;
        this.expected = expected;
        this.json = expected instanceof String
                ? "\"" + expected + "\""
                : String.valueOf(expected);
    }

    @Test
    public void parse() throws Exception {
        JsonParser parser = factory().createParser(new StringReader(json));

        if (mapper instanceof ValueMapper) {
            assertThat(((ValueMapper<?>) mapper).read(parser)).isEqualTo(expected);

        } else if (mapper instanceof PrimitiveBooleanMapper) {
            assertThat(((PrimitiveBooleanMapper) mapper).read(parser)).isEqualTo(expected);

        } else if (mapper instanceof PrimitiveIntMapper) {
            assertThat(((PrimitiveIntMapper) mapper).read(parser)).isEqualTo(expected);

        } else if (mapper instanceof PrimitiveLongMapper) {
            assertThat(((PrimitiveLongMapper) mapper).read(parser)).isEqualTo(expected);

        } else {
            throw new AssertionError(mapper.toString());
        }

    }

    @Test
    @SuppressWarnings("unchecked")
    public void generate() throws Exception {
        StringWriter writer = new StringWriter();
        JsonGenerator generator = factory().createGenerator(writer);

        if (mapper instanceof ValueMapper) {
            ((ValueMapper<Object>) mapper).write(generator, expected);

        } else if (mapper instanceof PrimitiveBooleanMapper) {
            ((PrimitiveBooleanMapper) mapper).write(generator, (boolean) expected);

        } else if (mapper instanceof PrimitiveIntMapper) {
            ((PrimitiveIntMapper) mapper).write(generator, (int) expected);

        } else if (mapper instanceof PrimitiveLongMapper) {
            ((PrimitiveLongMapper) mapper).write(generator, (long) expected);

        } else {
            throw new AssertionError(mapper.toString());
        }

        generator.flush();
        assertThat(writer.toString()).isEqualTo(json);
    }

    protected abstract JsonFactory factory();

}
