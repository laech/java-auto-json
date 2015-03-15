package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

// Example from https://tools.ietf.org/html/rfc7159
@AutoJson
@AutoValue
abstract class ObjectImage {

    @AutoJson.Name("Image")
    abstract Image image();

    @AutoJson
    @AutoValue
    static abstract class Image {

        @AutoJson.Name("Width")
        abstract int width();

        @AutoJson.Name("Height")
        abstract int height();

        @AutoJson.Name("Title")
        abstract String title();

        @AutoJson.Name("Thumbnail")
        abstract Thumbnail thumbnail();

        @AutoJson.Name("Animated")
        abstract boolean animated();

        // TODO
        // @AutoJson.Name("IDs")
        // abstract List<Integer> ids();

    }

    @AutoJson
    @AutoValue
    static abstract class Thumbnail {

        @AutoJson.Name("Url")
        abstract String url();

        @AutoJson.Name("Height")
        abstract int height();

        @AutoJson.Name("Width")
        abstract int width();

    }

}
