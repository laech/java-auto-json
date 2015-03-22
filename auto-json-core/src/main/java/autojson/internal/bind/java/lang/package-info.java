@SimpleMappers({
        @SimpleMapper(value = int.class, name = "PrimitiveIntMapper"),
        @SimpleMapper(value = long.class, name = "PrimitiveLongMapper"),
        @SimpleMapper(value = boolean.class, name = "PrimitiveBooleanMapper"),
        @SimpleMapper(value = Integer.class, parse = "parser.getInt()"),
        @SimpleMapper(Long.class),
        @SimpleMapper(Boolean.class),
        @SimpleMapper(String.class),
})
package autojson.internal.bind.java.lang;

import autojson.internal.SimpleMapper;
import autojson.internal.SimpleMappers;
