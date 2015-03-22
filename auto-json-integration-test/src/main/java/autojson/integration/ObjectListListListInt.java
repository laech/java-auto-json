package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoJson
@AutoValue
abstract class ObjectListListListInt {

    abstract List<List<List<Integer>>> values();

}
