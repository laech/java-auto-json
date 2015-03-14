package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

class ObjectStaticInnerClass {

    @AutoJson
    @AutoValue
    static abstract class Inner {
        abstract String value();
    }

}
