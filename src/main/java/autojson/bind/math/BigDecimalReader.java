package autojson.bind.math;

import autojson.bind.NullableValueReader;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.math.BigDecimal;

public final class BigDecimalReader extends NullableValueReader<BigDecimal> {

    @Override
    protected BigDecimal read(JsonParser parser, Event event) {
        return parser.getBigDecimal();
    }

}
