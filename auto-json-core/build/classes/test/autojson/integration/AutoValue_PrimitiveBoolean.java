
package autojson.integration;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_PrimitiveBoolean extends PrimitiveBoolean {

  private final boolean value;

  AutoValue_PrimitiveBoolean(
      boolean value) {
    this.value = value;
  }

  @Override
  boolean value() {
    return value;
  }

  @Override
  public String toString() {
    return "PrimitiveBoolean{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PrimitiveBoolean) {
      PrimitiveBoolean that = (PrimitiveBoolean) o;
      return (this.value == that.value());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= value ? 1231 : 1237;
    return h;
  }

}
