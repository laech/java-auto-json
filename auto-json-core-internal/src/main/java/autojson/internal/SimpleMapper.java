package autojson.internal;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Specified how a simple mapper is to be generated.
 * <p/>
 * This is intended for generating mappers which have simple implementations, or
 * will be able use much the default implementations provided by this annotation,
 * hence can save writing much repetitive coding through ou source files and let those
 * be generated instead.
 * <p/>
 * Complex mappers should be implemented in code and not used this annotation.
 * <p/>
 * Example usage (in the {@code package-info.java} file under a package):
 * <pre>
 *
 * &#64;SimpleMappers({
 *     &#64;SimpleMapper(value = long.class, name = "PrimitiveLongMapper"),
 *     &#64;SimpleMapper(value = Long.class),
 *     &#64;SimpleMapper(value = Integer.class),
 *     &#64;SimpleMapper(value = BigDecimal.class, parse = "new java.math.BigDecimal(parser.getString())"),
 * })
 * package my.package;
 * </pre>
 *
 * @see SimpleMappers
 */
@Target({})
@Retention(SOURCE)
public @interface SimpleMapper {

    /**
     * The target type to generate the mapper for.
     */
    Class<?> value();

    /**
     * The name of the generated mapper, if not specified, will use the
     * title case version of the target type's simple name + "Mapper",
     * e.g. {@code LongMapper}
     */
    String name() default "";

    /**
     * The simple source code for getting the value from the parser, a variable
     * {@code parser} of type {@code autojson.stream.JsonParser} is in scope.
     * If not specified will used the default:
     * {@code parser.get&lt;title case target type simple name&gt;()},
     * e.g. {@code parser.getLong()}
     */
    String parse() default "";

    /**
     * The simple source code for writing the value to the generator, a variable
     * {@code generator} of type {@code autojson.stream.JsonGenerator} and a variable
     * {@code value} of the target type is in scope.
     * If not specified will use the default: {@code generator.writeValue(value)}
     */
    String generate() default "";

}
