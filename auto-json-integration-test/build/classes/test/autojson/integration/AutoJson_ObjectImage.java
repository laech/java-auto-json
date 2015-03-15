package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectImage extends autojson.bind.NullableMapper<ObjectImage> {

    @Override
    protected ObjectImage readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new autojson.bind.JsonBindException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        autojson.integration.ObjectImage.Image image = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "Image":
                    image = imageRead(_parser);
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
        imageWrite(generator, element);
        generator.writeEndObject();
    }

    private autojson.integration.ObjectImage.Image imageRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        AutoJson_ObjectImage_Image mapper = autojson.bind.MapperCache.get(AutoJson_ObjectImage_Image.class);
        if (mapper == null) {
            mapper = new AutoJson_ObjectImage_Image();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void imageWrite(autojson.stream.JsonGenerator generator, ObjectImage element) throws java.io.IOException {
        AutoJson_ObjectImage_Image mapper = autojson.bind.MapperCache.get(AutoJson_ObjectImage_Image.class);
        if (mapper == null) {
            mapper = new AutoJson_ObjectImage_Image();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Image");
        mapper.write(generator, element.image());
    }

}
