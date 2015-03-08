package autojson.bind;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParsingException;

public interface ValueReader<T> {

    /**
     * @throws JsonBindException
     * @throws JsonParsingException
     */
    T read(JsonParser parser);

}
