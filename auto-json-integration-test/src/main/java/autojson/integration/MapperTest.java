package autojson.integration;

import autojson.bind.Mapper;
import autojson.internal.bind.java.lang.PrimitiveBooleanMapper;
import autojson.internal.bind.java.lang.PrimitiveIntMapper;
import autojson.internal.bind.java.lang.PrimitiveLongMapper;
import autojson.stream.JsonFactory;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public abstract class MapperTest {

    private final Object mapper;
    private final String expectedJson;
    private final String inputJson;

    public MapperTest(Object mapper, String expectedJson, String inputJson) {
        this.mapper = mapper;
        this.inputJson = inputJson;
        this.expectedJson = expectedJson;
    }

    @Parameterized.Parameters(name = "{0} {1}")
    public static Collection<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        URL url = MapperTest.class.getResource("tests.xml");
        TestCases tests = JAXB.unmarshal(url, TestCases.class);

        for (TestCase test : tests.getTests()) {
            try {
                add(data, test);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Failed to initiate "
                        + test.getMapper() + " "
                        + test.getWrappers());
            }
        }

        return data;
    }

    private static void add(List<Object[]> data, TestCase test) throws ReflectiveOperationException {
        Object mapper = Class.forName(test.getMapper()).newInstance();

        if (!test.getWrappers().isEmpty()) {
            for (String wrapperClass : test.getWrappers()) {
                Constructor<?> constructor = Class.forName(wrapperClass).getConstructor(Mapper.class);
                Object wrapper = constructor.newInstance(mapper);
                for (String expect : test.getCases()) {
                    data.add(new Object[]{wrapper, expect, expect});
                }
                for (TestCaseIo io : test.getIocases()) {
                    data.add(new Object[]{mapper, io.getOutput(), io.getInput()});
                }
            }
        } else {

            for (String expect : test.getCases()) {
                data.add(new Object[]{mapper, expect, expect});
            }

            for (TestCaseIo io : test.getIocases()) {
                data.add(new Object[]{mapper, io.getOutput(), io.getInput()});
            }
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test() throws Exception {
        StringWriter writer = new StringWriter(expectedJson.length());
        JsonParser parser = factory().createParser(new StringReader(inputJson));
        JsonGenerator generator = factory().createGenerator(writer);

        if (mapper instanceof Mapper) {
            Mapper<Object> mapper = (Mapper<Object>) this.mapper;
            mapper.write(generator, mapper.read(parser));

        } else if (mapper instanceof PrimitiveBooleanMapper) {
            PrimitiveBooleanMapper mapper = (PrimitiveBooleanMapper) this.mapper;
            mapper.write(generator, mapper.read(parser));

        } else if (mapper instanceof PrimitiveIntMapper) {
            PrimitiveIntMapper mapper = (PrimitiveIntMapper) this.mapper;
            mapper.write(generator, mapper.read(parser));

        } else if (mapper instanceof PrimitiveLongMapper) {
            PrimitiveLongMapper mapper = (PrimitiveLongMapper) this.mapper;
            mapper.write(generator, mapper.read(parser));

        } else {
            throw new AssertionError(mapper.toString());
        }

        generator.flush();
        assertEquals(expectedJson, writer.toString());
    }

    protected abstract JsonFactory factory();

}
