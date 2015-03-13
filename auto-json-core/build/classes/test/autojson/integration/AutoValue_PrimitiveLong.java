
package autojson.integration;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_PrimitiveLong extends PrimitiveLong {

  private final long value;

  AutoValue_PrimitiveLong(
      long value) {
    this.value = value;
  }

  @Override
  long value() {
    return value;
  }

  @Override
  public String toString() {
    return "PrimitiveLong{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PrimitiveLong) {
      PrimitiveLong that = (PrimitiveLong) o;
      return (this.value == that.value());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (value >>> 32) ^ value;
    return h;
  }

}
