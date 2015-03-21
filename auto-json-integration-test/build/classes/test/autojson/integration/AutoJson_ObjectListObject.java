package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectListObject extends autojson.bind.NullableMapper<ObjectListObject> {

    private static final autojson.bind.Mapper<java.util.List<autojson.integration.ObjectString>> valuesMapper = new autojson.bind.java.util.ListMapper<>(new AutoJson_ObjectString());

    @Override
    protected ObjectListObject readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.util.List<autojson.integration.ObjectString> values = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "values":
                    values = valuesMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectListObject(values);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectListObject element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("values");
        valuesMapper.write(generator, element.values());
        generator.writeEndObject();
    }

}
