
package autojson.integration;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_PrimitiveInt extends PrimitiveInt {

  private final int value;

  AutoValue_PrimitiveInt(
      int value) {
    this.value = value;
  }

  @Override
  int value() {
    return value;
  }

  @Override
  public String toString() {
    return "PrimitiveInt{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PrimitiveInt) {
      PrimitiveInt that = (PrimitiveInt) o;
      return (this.value == that.value());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= value;
    return h;
  }

}
