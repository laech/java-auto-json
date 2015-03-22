package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectListListListInt extends autojson.bind.NullableMapper<ObjectListListListInt> {

    private static final autojson.bind.Mapper<java.util.List<java.util.List<java.util.List<java.lang.Integer>>>> valuesMapper = new autojson.internal.bind.java.util.ListMapper<>(new autojson.internal.bind.java.util.ListMapper<>(new autojson.internal.bind.java.util.ListMapper<>(new autojson.internal.bind.java.lang.IntegerMapper())));

    @Override
    protected ObjectListListListInt readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.util.List<java.util.List<java.util.List<java.lang.Integer>>> values = null;
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
        return new AutoValue_ObjectListListListInt(values);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectListListListInt element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("values");
        valuesMapper.write(generator, element.values());
        generator.writeEndObject();
    }

}
