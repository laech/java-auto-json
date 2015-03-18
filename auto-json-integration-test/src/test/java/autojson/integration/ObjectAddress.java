package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

import java.math.BigDecimal;

// Example from https://tools.ietf.org/html/rfc7159
@AutoJson
@AutoValue
abstract class ObjectAddress {

    abstract String precision();

    @AutoJson.Name("Latitude")
    abstract BigDecimal latitude();
//    abstract double latitude(); // TODO

    @AutoJson.Name("Longitude")
    abstract BigDecimal longitude();
//    abstract double longitude(); // TODO

    @AutoJson.Name("Address")
    abstract String address();

    @AutoJson.Name("City")
    abstract String city();

    @AutoJson.Name("State")
    abstract String state();

    @AutoJson.Name("Zip")
    abstract String zip();

    @AutoJson.Name("Country")
    abstract String country();

}
