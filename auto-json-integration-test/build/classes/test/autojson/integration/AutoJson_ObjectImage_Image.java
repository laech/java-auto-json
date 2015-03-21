package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectImage_Image extends autojson.bind.NullableMapper<ObjectImage.Image> {

    private static final autojson.bind.java.lang.PrimitiveIntMapper widthMapper = new autojson.bind.java.lang.PrimitiveIntMapper();
    private static final autojson.bind.java.lang.PrimitiveIntMapper heightMapper = new autojson.bind.java.lang.PrimitiveIntMapper();
    private static final autojson.bind.Mapper<java.lang.String> titleMapper = new autojson.bind.java.lang.StringMapper();
    private static final autojson.bind.Mapper<autojson.integration.ObjectImage.Thumbnail> thumbnailMapper = new AutoJson_ObjectImage_Thumbnail();
    private static final autojson.bind.java.lang.PrimitiveBooleanMapper animatedMapper = new autojson.bind.java.lang.PrimitiveBooleanMapper();
    private static final autojson.bind.Mapper<java.util.List<java.lang.Integer>> idsMapper = new autojson.bind.java.util.ListMapper<>(new autojson.bind.java.lang.IntegerMapper());

    @Override
    protected ObjectImage.Image readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        int width = 0;
        int height = 0;
        java.lang.String title = null;
        autojson.integration.ObjectImage.Thumbnail thumbnail = null;
        boolean animated = false;
        java.util.List<java.lang.Integer> ids = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "Width":
                    width = widthMapper.read(_parser);
                    break;
                case "Height":
                    height = heightMapper.read(_parser);
                    break;
                case "Title":
                    title = titleMapper.read(_parser);
                    break;
                case "Thumbnail":
                    thumbnail = thumbnailMapper.read(_parser);
                    break;
                case "Animated":
                    animated = animatedMapper.read(_parser);
                    break;
                case "IDs":
                    ids = idsMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectImage_Image(width, height, title, thumbnail, animated, ids);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectImage.Image element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("Width");
        widthMapper.write(generator, element.width());
        generator.writeName("Height");
        heightMapper.write(generator, element.height());
        generator.writeName("Title");
        titleMapper.write(generator, element.title());
        generator.writeName("Thumbnail");
        thumbnailMapper.write(generator, element.thumbnail());
        generator.writeName("Animated");
        animatedMapper.write(generator, element.animated());
        generator.writeName("IDs");
        idsMapper.write(generator, element.ids());
        generator.writeEndObject();
    }

}
