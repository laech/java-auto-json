package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectImage_Thumbnail extends autojson.bind.NullableMapper<ObjectImage.Thumbnail> {

    private static final autojson.bind.Mapper<java.lang.String> urlMapper = new autojson.internal.bind.java.lang.StringMapper();
    private static final autojson.internal.bind.java.lang.PrimitiveIntMapper heightMapper = new autojson.internal.bind.java.lang.PrimitiveIntMapper();
    private static final autojson.internal.bind.java.lang.PrimitiveIntMapper widthMapper = new autojson.internal.bind.java.lang.PrimitiveIntMapper();

    @Override
    protected ObjectImage.Thumbnail readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.lang.String url = null;
        int height = 0;
        int width = 0;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "Url":
                    url = urlMapper.read(_parser);
                    break;
                case "Height":
                    height = heightMapper.read(_parser);
                    break;
                case "Width":
                    width = widthMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectImage_Thumbnail(url, height, width);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectImage.Thumbnail element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("Url");
        urlMapper.write(generator, element.url());
        generator.writeName("Height");
        heightMapper.write(generator, element.height());
        generator.writeName("Width");
        widthMapper.write(generator, element.width());
        generator.writeEndObject();
    }

}
