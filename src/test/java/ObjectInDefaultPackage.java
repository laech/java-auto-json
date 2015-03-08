import autojson.AutoJson;
import com.google.auto.value.AutoValue;

@AutoJson
@AutoValue
public abstract class ObjectInDefaultPackage {

    abstract String value();

    public static ObjectInDefaultPackage create(String value) {
        return new AutoValue_ObjectInDefaultPackage(value);
    }

}
