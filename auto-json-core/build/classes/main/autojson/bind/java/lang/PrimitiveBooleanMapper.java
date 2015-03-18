package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class PrimitiveBooleanMapper {

    public boolean read(autojson.stream.JsonParser parser) throws java.io.IOException {
        if (!parser.next()) {
            throw new IllegalStateException("No more token from parser");
        }
        return readCurrent(parser);
    }

    public boolean readCurrent(autojson.stream.JsonParser parser) throws java.io.IOException {
        return parser.getBoolean();
    }

    public void write(autojson.stream.JsonGenerator generator, boolean value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
