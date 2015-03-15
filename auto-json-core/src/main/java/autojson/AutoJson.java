package autojson;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Documented
@Target(TYPE)
@Retention(SOURCE)
public @interface AutoJson {

    /**
     * Specifies an alternative JSON name to be used for a given property.
     */
    @Documented
    @Target({FIELD, METHOD})
    @Retention(SOURCE)
    public @interface Name {
        String value();
    }

}
