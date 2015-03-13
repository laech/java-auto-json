package autojson.stream;

import autojson.JsonException;

public class JsonStreamException extends JsonException {

    private static final long serialVersionUID = 1L;

    public JsonStreamException() {
        super();
    }

    public JsonStreamException(String message) {
        super(message);
    }

    public JsonStreamException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonStreamException(Throwable cause) {
        super(cause);
    }

}
