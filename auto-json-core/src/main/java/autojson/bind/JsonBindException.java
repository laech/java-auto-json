package autojson.bind;

import autojson.JsonException;

public class JsonBindException extends JsonException {

    private static final long serialVersionUID = 1L;

    public JsonBindException() {
        super();
    }

    public JsonBindException(String message) {
        super(message);
    }

    public JsonBindException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonBindException(Throwable cause) {
        super(cause);
    }

}
