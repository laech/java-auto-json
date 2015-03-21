package autojson.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Specified how a simple collection mapper is to be generated.
 * <p/>
 * Example usage (in the {@code package-info.java} file under a package):
 * <pre>
 *
 * &#64;SimpleCollectionMappers({
 *     &#64;SimpleCollectionMapper(value = HashSet.class),
 *     &#64;SimpleCollectionMapper(value = ArrayList.class, declareAs = List.class)
 * })
 * package my.package;
 * </pre>
 *
 * @see SimpleCollectionMappers
 */
@Documented
@Target(PACKAGE)
@Retention(SOURCE)
public @interface SimpleCollectionMapper {

    /**
     * The declared collection type for mapper to produce and consume, must be a
     * super type/interface of {@link #value()}.
     */
    Class<?> declareAs() default Void.class;

    /**
     * The concrete collection type to instantiate, must have a public no
     * argument constructor.
     */
    Class<?> value();

}
