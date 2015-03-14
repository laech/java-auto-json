@SimpleMappers({
        @SimpleMapper(type = int.class, name = "PrimitiveIntMapper"),
        @SimpleMapper(type = long.class, name = "PrimitiveLongMapper"),
        @SimpleMapper(type = boolean.class, name = "PrimitiveBooleanMapper"),
        @SimpleMapper(type = Long.class),
        @SimpleMapper(type = Integer.class, parse = "parser.getInt()"),
        @SimpleMapper(type = Boolean.class),
        @SimpleMapper(type = String.class),
})
package autojson.bind.java.lang;

import autojson.internal.SimpleMapper;
import autojson.internal.SimpleMappers;
