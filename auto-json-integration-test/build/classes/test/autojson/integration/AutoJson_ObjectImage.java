package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectImage extends autojson.bind.NullableMapper<ObjectImage> {

    private static final autojson.bind.Mapper<autojson.integration.ObjectImage.Image> imageMapper = new AutoJson_ObjectImage_Image();

    @Override
    protected ObjectImage readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        autojson.integration.ObjectImage.Image image = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "Image":
                    image = imageMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectImage(image);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectImage element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("Image");
        imageMapper.write(generator, element.image());
        generator.writeEndObject();
    }

}
