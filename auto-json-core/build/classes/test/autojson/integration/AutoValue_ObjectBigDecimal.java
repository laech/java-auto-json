
package autojson.integration;

import java.math.BigDecimal;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ObjectBigDecimal extends ObjectBigDecimal {

  private final BigDecimal value;

  AutoValue_ObjectBigDecimal(
      BigDecimal value) {
    if (value == null) {
      throw new NullPointerException("Null value");
    }
    this.value = value;
  }

  @Override
  BigDecimal value() {
    return value;
  }

  @Override
  public String toString() {
    return "ObjectBigDecimal{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ObjectBigDecimal) {
      ObjectBigDecimal that = (ObjectBigDecimal) o;
      return (this.value.equals(that.value()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= value.hashCode();
    return h;
  }

}
