package autojson.bind.math;

import autojson.bind.JsonBindException;
import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.math.BigDecimal;

public final class BigDecimalReader extends NullableValueReader<BigDecimal> {

    public static final BigDecimalReader INSTANCE = new BigDecimalReader();

    @Override
    protected BigDecimal read(JsonParser parser, Event event) {
        try {
            return parser.getBigDecimal();
        } catch (IllegalStateException e) {
            throw JsonBindException.rethrow(parser.getLocation(), event, BigDecimal.class, e);
        }
    }

}
