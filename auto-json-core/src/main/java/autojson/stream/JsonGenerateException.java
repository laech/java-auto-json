package autojson.stream;

public class JsonGenerateException extends JsonStreamException {

    private static final long serialVersionUID = 1L;

    public JsonGenerateException() {
        super();
    }

    public JsonGenerateException(String message) {
        super(message);
    }

    public JsonGenerateException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonGenerateException(Throwable cause) {
        super(cause);
    }

}
