@SimpleMappers({
        @SimpleMapper(value = BigDecimal.class, parse = "new java.math.BigDecimal(parser.getString())"),
})
package autojson.internal.bind.java.math;

import autojson.internal.SimpleMapper;
import autojson.internal.SimpleMappers;

import java.math.BigDecimal;
