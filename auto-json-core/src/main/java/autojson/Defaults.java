package autojson;

import javax.lang.model.type.TypeMirror;

final class Defaults {

    private Defaults() {
    }

    public static String getSource(TypeMirror type) {
        switch (type.getKind()) {
            case BOOLEAN:
                return "false";
            case CHAR:
                return "'\\0'";
            case BYTE:
                return "(byte) 0";
            case SHORT:
                return "(short) 0";
            case INT:
                return "0";
            case LONG:
                return "0L";
            case FLOAT:
                return "0f";
            case DOUBLE:
                return "0d";
            default:
                return "null";
        }
    }

}
