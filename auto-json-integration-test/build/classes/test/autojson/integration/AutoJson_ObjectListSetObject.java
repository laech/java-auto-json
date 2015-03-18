package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectListSetObject extends autojson.bind.NullableMapper<ObjectListSetObject> {

    private static final autojson.bind.Mapper<java.util.List<java.util.Set<autojson.integration.ObjectInt>>> valuesMapper = new autojson.bind.java.util.ListMapper(new autojson.bind.java.util.SetMapper(new AutoJson_ObjectInt()));

    @Override
    protected ObjectListSetObject readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.util.List<java.util.Set<autojson.integration.ObjectInt>> values = null;
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
        return new AutoValue_ObjectListSetObject(values);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectListSetObject element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("values");
        valuesMapper.write(generator, element.values());
        generator.writeEndObject();
    }

}
