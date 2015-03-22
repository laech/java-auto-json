package autojson.integration;

import autojson.bind.Mapper;
import autojson.internal.bind.java.lang.PrimitiveBooleanMapper;
import autojson.internal.bind.java.lang.PrimitiveIntMapper;
import autojson.internal.bind.java.lang.PrimitiveLongMapper;
import autojson.stream.JsonFactory;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public abstract class MapperTest {

    private final Object mapper;
    private final Object object;
    private final String json;

    public MapperTest(Object mapper, Object object, String json) {
        this.mapper = mapper;
        this.object = object;
        this.json = json;
    }

    @Test
    public void read() throws Exception {
        JsonParser parser = factory().createParser(new StringReader(json));

        if (mapper instanceof Mapper) {
            assertEquals(object, ((Mapper<?>) mapper).read(parser));

        } else if (mapper instanceof PrimitiveBooleanMapper) {
            assertEquals(object, ((PrimitiveBooleanMapper) mapper).read(parser));

        } else if (mapper instanceof PrimitiveIntMapper) {
            assertEquals(object, ((PrimitiveIntMapper) mapper).read(parser));

        } else if (mapper instanceof PrimitiveLongMapper) {
            assertEquals(object, ((PrimitiveLongMapper) mapper).read(parser));

        } else {
            throw new AssertionError(mapper.toString());
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void write() throws Exception {
        StringWriter writer = new StringWriter();
        JsonGenerator generator = factory().createGenerator(writer);

        if (mapper instanceof Mapper) {
            ((Mapper<Object>) mapper).write(generator, object);

        } else if (mapper instanceof PrimitiveBooleanMapper) {
            ((PrimitiveBooleanMapper) mapper).write(generator, (boolean) object);

        } else if (mapper instanceof PrimitiveIntMapper) {
            ((PrimitiveIntMapper) mapper).write(generator, (int) object);

        } else if (mapper instanceof PrimitiveLongMapper) {
            ((PrimitiveLongMapper) mapper).write(generator, (long) object);

        } else {
            throw new AssertionError(mapper.toString());
        }

        generator.flush();
        assertEquals(json, writer.toString());
    }

    protected abstract JsonFactory factory();

}
