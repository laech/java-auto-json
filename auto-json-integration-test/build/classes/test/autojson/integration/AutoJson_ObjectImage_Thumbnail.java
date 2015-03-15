package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectImage_Thumbnail extends autojson.bind.NullableMapper<ObjectImage.Thumbnail> {

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
                    url = urlRead(_parser);
                    break;
                case "Height":
                    height = heightRead(_parser);
                    break;
                case "Width":
                    width = widthRead(_parser);
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
        urlWrite(generator, element);
        heightWrite(generator, element);
        widthWrite(generator, element);
        generator.writeEndObject();
    }

    private java.lang.String urlRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.StringMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.StringMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.StringMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private int heightRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private int widthRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void urlWrite(autojson.stream.JsonGenerator generator, ObjectImage.Thumbnail element) throws java.io.IOException {
        autojson.bind.java.lang.StringMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.StringMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.StringMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Url");
        mapper.write(generator, element.url());
    }

    private void heightWrite(autojson.stream.JsonGenerator generator, ObjectImage.Thumbnail element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Height");
        mapper.write(generator, element.height());
    }

    private void widthWrite(autojson.stream.JsonGenerator generator, ObjectImage.Thumbnail element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Width");
        mapper.write(generator, element.width());
    }

}
