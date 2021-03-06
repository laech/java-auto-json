package autojson.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Annotates a package element (e.g. in {@code package-info.java})
 * for generating simple mappers. See {@link SimpleMapper} for more details.
 */
@Documented
@Target(PACKAGE)
@Retention(SOURCE)
public @interface SimpleMappers {

    SimpleMapper[] value();

}
