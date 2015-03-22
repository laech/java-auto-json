package autojson.integration;

import autojson.internal.bind.java.lang.BooleanMapper;
import autojson.internal.bind.java.lang.IntegerMapper;
import autojson.internal.bind.java.lang.LongMapper;
import autojson.internal.bind.java.lang.PrimitiveBooleanMapper;
import autojson.internal.bind.java.lang.PrimitiveIntMapper;
import autojson.internal.bind.java.lang.PrimitiveLongMapper;
import autojson.internal.bind.java.lang.StringMapper;
import autojson.internal.bind.java.math.BigDecimalMapper;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Collection;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public abstract class BasicMapperTest extends MapperTest {

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

    public BasicMapperTest(Object mapper, Object expected) {
        super(mapper, expected,
                expected instanceof String
                        ? "\"" + expected + "\""
                        : String.valueOf(expected));
    }

}
