package autojson.internal.bind;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

// TODO
@Documented
@Target(TYPE)
@Retention(SOURCE)
public @interface Defaults {
}
