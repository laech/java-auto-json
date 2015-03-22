package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectNestedAutoJsonMulti extends autojson.bind.NullableMapper<ObjectNestedAutoJsonMulti> {

    private static final autojson.bind.Mapper<autojson.integration.ObjectString> stringValueMapper = new AutoJson_ObjectString();
    private static final autojson.bind.Mapper<autojson.integration.PrimitiveInt> intValueMapper = new AutoJson_PrimitiveInt();
    private static final autojson.internal.bind.java.lang.PrimitiveLongMapper longValueMapper = new autojson.internal.bind.java.lang.PrimitiveLongMapper();

    @Override
    protected ObjectNestedAutoJsonMulti readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        autojson.integration.ObjectString stringValue = null;
        autojson.integration.PrimitiveInt intValue = null;
        long longValue = 0L;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "stringValue":
                    stringValue = stringValueMapper.read(_parser);
                    break;
                case "intValue":
                    intValue = intValueMapper.read(_parser);
                    break;
                case "longValue":
                    longValue = longValueMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectNestedAutoJsonMulti(stringValue, intValue, longValue);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectNestedAutoJsonMulti element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("stringValue");
        stringValueMapper.write(generator, element.stringValue());
        generator.writeName("intValue");
        intValueMapper.write(generator, element.intValue());
        generator.writeName("longValue");
        longValueMapper.write(generator, element.longValue());
        generator.writeEndObject();
    }

}
