package autojson.bind;

import autojson.bind.java.lang.PrimitiveBooleanMapper;
import autojson.bind.java.lang.PrimitiveIntMapper;
import autojson.bind.java.lang.PrimitiveLongMapper;
import autojson.stream.JsonFactory;
import autojson.stream.JsonGenerator;
import autojson.stream.JsonParser;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static com.google.common.truth.Truth.assertThat;

public abstract class MapperTest {

    private final Object mapper;
    private final Object object;
    private final String json;

    public <T> MapperTest(Object mapper, T object, String json) {
        this.mapper = mapper;
        this.object = object;
        this.json = json;
    }

    @Test
    public void read() throws Exception {
        JsonParser parser = factory().createParser(new StringReader(json));

        if (mapper instanceof ValueMapper) {
            assertThat(((ValueMapper<?>) mapper).read(parser)).isEqualTo(object);

        } else if (mapper instanceof PrimitiveBooleanMapper) {
            assertThat(((PrimitiveBooleanMapper) mapper).read(parser)).isEqualTo(object);

        } else if (mapper instanceof PrimitiveIntMapper) {
            assertThat(((PrimitiveIntMapper) mapper).read(parser)).isEqualTo(object);

        } else if (mapper instanceof PrimitiveLongMapper) {
            assertThat(((PrimitiveLongMapper) mapper).read(parser)).isEqualTo(object);

        } else {
            throw new AssertionError(mapper.toString());
        }

    }

    @Test
    @SuppressWarnings("unchecked")
    public void write() throws Exception {
        StringWriter writer = new StringWriter();
        JsonGenerator generator = factory().createGenerator(writer);

        if (mapper instanceof ValueMapper) {
            ((ValueMapper<Object>) mapper).write(generator, object);

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
        assertThat(writer.toString()).isEqualTo(json);
    }

    protected abstract JsonFactory factory();

}
