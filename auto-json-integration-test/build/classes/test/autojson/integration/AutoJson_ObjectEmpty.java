package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectEmpty extends autojson.bind.NullableMapper<ObjectEmpty> {

    @Override
    protected ObjectEmpty readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectEmpty();
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectEmpty element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeEndObject();
    }

}
