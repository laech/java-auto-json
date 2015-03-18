package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectAddress extends autojson.bind.NullableMapper<ObjectAddress> {

    private static final autojson.bind.Mapper<java.lang.String> precisionMapper = new autojson.bind.java.lang.StringMapper();
    private static final autojson.bind.Mapper<java.math.BigDecimal> latitudeMapper = new autojson.bind.java.math.BigDecimalMapper();
    private static final autojson.bind.Mapper<java.math.BigDecimal> longitudeMapper = new autojson.bind.java.math.BigDecimalMapper();
    private static final autojson.bind.Mapper<java.lang.String> addressMapper = new autojson.bind.java.lang.StringMapper();
    private static final autojson.bind.Mapper<java.lang.String> cityMapper = new autojson.bind.java.lang.StringMapper();
    private static final autojson.bind.Mapper<java.lang.String> stateMapper = new autojson.bind.java.lang.StringMapper();
    private static final autojson.bind.Mapper<java.lang.String> zipMapper = new autojson.bind.java.lang.StringMapper();
    private static final autojson.bind.Mapper<java.lang.String> countryMapper = new autojson.bind.java.lang.StringMapper();

    @Override
    protected ObjectAddress readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.lang.String precision = null;
        java.math.BigDecimal latitude = null;
        java.math.BigDecimal longitude = null;
        java.lang.String address = null;
        java.lang.String city = null;
        java.lang.String state = null;
        java.lang.String zip = null;
        java.lang.String country = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "precision":
                    precision = precisionMapper.read(_parser);
                    break;
                case "Latitude":
                    latitude = latitudeMapper.read(_parser);
                    break;
                case "Longitude":
                    longitude = longitudeMapper.read(_parser);
                    break;
                case "Address":
                    address = addressMapper.read(_parser);
                    break;
                case "City":
                    city = cityMapper.read(_parser);
                    break;
                case "State":
                    state = stateMapper.read(_parser);
                    break;
                case "Zip":
                    zip = zipMapper.read(_parser);
                    break;
                case "Country":
                    country = countryMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectAddress(precision, latitude, longitude, address, city, state, zip, country);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectAddress element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("precision");
        precisionMapper.write(generator, element.precision());
        generator.writeName("Latitude");
        latitudeMapper.write(generator, element.latitude());
        generator.writeName("Longitude");
        longitudeMapper.write(generator, element.longitude());
        generator.writeName("Address");
        addressMapper.write(generator, element.address());
        generator.writeName("City");
        cityMapper.write(generator, element.city());
        generator.writeName("State");
        stateMapper.write(generator, element.state());
        generator.writeName("Zip");
        zipMapper.write(generator, element.zip());
        generator.writeName("Country");
        countryMapper.write(generator, element.country());
        generator.writeEndObject();
    }

}
