package autojson.bind.java.lang;

@javax.annotation.Generated("autojson.internal.SimpleMappersProcessor")
public final class PrimitiveLongMapper {

    public long read(autojson.stream.JsonParser parser) throws java.io.IOException {
        if (!parser.next()) {
            throw new autojson.bind.JsonBindException("No more token from parser");
        }
        return parser.getLong();
    }

    public void write(autojson.stream.JsonGenerator generator, long value) throws java.io.IOException {
        generator.writeValue(value);
    }

}
