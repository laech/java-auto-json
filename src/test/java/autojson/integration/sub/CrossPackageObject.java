package autojson.integration.sub;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

@AutoJson
@AutoValue
public abstract class CrossPackageObject {

    public abstract int value();

    public static CrossPackageObject create(int value) {
        return new AutoValue_CrossPackageObject(value);
    }

}
