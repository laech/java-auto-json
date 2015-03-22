package autojson.internal.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class PrimitiveIntMapper {

    public int read(autojson.stream.JsonParser parser) throws java.io.IOException {
        if (!parser.next()) {
            throw new IllegalStateException("No more token from parser");
        }
        return readCurrent(parser);
    }

    public int readCurrent(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getInt();
    }

    public void write(autojson.stream.JsonGenerator generator, int value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
