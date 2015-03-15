package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectImage_Image extends autojson.bind.NullableMapper<ObjectImage.Image> {

    @Override
    protected ObjectImage.Image readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new autojson.bind.JsonBindException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        int width = 0;
        int height = 0;
        java.lang.String title = null;
        autojson.integration.ObjectImage.Thumbnail thumbnail = null;
        boolean animated = false;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "Width":
                    width = widthRead(_parser);
                    break;
                case "Height":
                    height = heightRead(_parser);
                    break;
                case "Title":
                    title = titleRead(_parser);
                    break;
                case "Thumbnail":
                    thumbnail = thumbnailRead(_parser);
                    break;
                case "Animated":
                    animated = animatedRead(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectImage_Image(width, height, title, thumbnail, animated);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectImage.Image element) throws java.io.IOException {
        generator.writeBeginObject();
        widthWrite(generator, element);
        heightWrite(generator, element);
        titleWrite(generator, element);
        thumbnailWrite(generator, element);
        animatedWrite(generator, element);
        generator.writeEndObject();
    }

    private int widthRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
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

    private java.lang.String titleRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.StringMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.StringMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.StringMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private autojson.integration.ObjectImage.Thumbnail thumbnailRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        AutoJson_ObjectImage_Thumbnail mapper = autojson.bind.MapperCache.get(AutoJson_ObjectImage_Thumbnail.class);
        if (mapper == null) {
            mapper = new AutoJson_ObjectImage_Thumbnail();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private boolean animatedRead(autojson.stream.JsonParser parser) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveBooleanMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveBooleanMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveBooleanMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        return mapper.read(parser);
    }

    private void widthWrite(autojson.stream.JsonGenerator generator, ObjectImage.Image element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Width");
        mapper.write(generator, element.width());
    }

    private void heightWrite(autojson.stream.JsonGenerator generator, ObjectImage.Image element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveIntMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveIntMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveIntMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Height");
        mapper.write(generator, element.height());
    }

    private void titleWrite(autojson.stream.JsonGenerator generator, ObjectImage.Image element) throws java.io.IOException {
        autojson.bind.java.lang.StringMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.StringMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.StringMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Title");
        mapper.write(generator, element.title());
    }

    private void thumbnailWrite(autojson.stream.JsonGenerator generator, ObjectImage.Image element) throws java.io.IOException {
        AutoJson_ObjectImage_Thumbnail mapper = autojson.bind.MapperCache.get(AutoJson_ObjectImage_Thumbnail.class);
        if (mapper == null) {
            mapper = new AutoJson_ObjectImage_Thumbnail();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Thumbnail");
        mapper.write(generator, element.thumbnail());
    }

    private void animatedWrite(autojson.stream.JsonGenerator generator, ObjectImage.Image element) throws java.io.IOException {
        autojson.bind.java.lang.PrimitiveBooleanMapper mapper = autojson.bind.MapperCache.get(autojson.bind.java.lang.PrimitiveBooleanMapper.class);
        if (mapper == null) {
            mapper = new autojson.bind.java.lang.PrimitiveBooleanMapper();
            autojson.bind.MapperCache.put(mapper);
        }
        generator.writeName("Animated");
        mapper.write(generator, element.animated());
    }

}
