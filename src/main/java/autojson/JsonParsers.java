package autojson;

import javax.json.stream.JsonParser;

public final class JsonParsers {

    private JsonParsers() {
    }

    public static void skipTree(JsonParser parser) {
        for (int i = 0; parser.hasNext(); ) {
            switch (parser.next()) {
                case START_OBJECT:
                case START_ARRAY:
                    i++;
                    break;
                case END_ARRAY:
                case END_OBJECT:
                    i--;
                    break;
            }
            if (i == 0) {
                break;
            }
        }
    }

}
