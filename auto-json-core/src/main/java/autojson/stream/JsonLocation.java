package autojson.stream;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class JsonLocation {

    JsonLocation() {
    }

    public abstract long getLineNumber();

    public abstract long getColumnNumber();

    public abstract long getOffset();

    public static JsonLocation create(long line, long column, long offset) {
        return new AutoValue_JsonLocation(line, column, offset);
    }

}
