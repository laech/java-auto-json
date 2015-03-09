import org.junit.Test;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public final class ObjectInDefaultPackageTest {

    @Test
    public void objectInDefaultPackage() throws Exception {
        JsonParser parser = Json.createParser(new StringReader("{\"value\":\"hello\"}"));
        ObjectInDefaultPackage expected = ObjectInDefaultPackage.create("hello");
        ObjectInDefaultPackage actual = new AutoJson_ObjectInDefaultPackage().read(parser);
        assertEquals(expected, actual);
    }

}
