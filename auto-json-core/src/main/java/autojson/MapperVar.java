package autojson;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class MapperVar {

    MapperVar() {
    }

    public abstract String getType();

    public abstract String getName();

    public abstract String getCreation();

    public static MapperVar create(String type, String name, String creation) {
        return new AutoValue_MapperVar(type, name, creation);
    }

}
