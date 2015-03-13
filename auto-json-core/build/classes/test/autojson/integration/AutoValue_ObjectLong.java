
package autojson.integration;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ObjectLong extends ObjectLong {

  private final Long value;

  AutoValue_ObjectLong(
      Long value) {
    this.value = value;
  }

  @javax.annotation.Nullable

  @Override
  Long value() {
    return value;
  }

  @Override
  public String toString() {
    return "ObjectLong{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ObjectLong) {
      ObjectLong that = (ObjectLong) o;
      return ((this.value == null) ? (that.value() == null) : this.value.equals(that.value()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (value == null) ? 0 : value.hashCode();
    return h;
  }

}
