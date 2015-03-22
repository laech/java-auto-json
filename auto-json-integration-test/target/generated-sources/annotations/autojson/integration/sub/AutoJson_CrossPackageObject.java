package autojson.integration.sub;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_CrossPackageObject extends autojson.bind.NullableMapper<CrossPackageObject> {

    private static final autojson.internal.bind.java.lang.PrimitiveIntMapper valueMapper = new autojson.internal.bind.java.lang.PrimitiveIntMapper();

    @Override
    protected CrossPackageObject readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        int value = 0;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "value":
                    value = valueMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_CrossPackageObject(value);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, CrossPackageObject element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("value");
        valueMapper.write(generator, element.value());
        generator.writeEndObject();
    }

}
