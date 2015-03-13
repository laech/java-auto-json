
package autojson.integration;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ObjectInt extends ObjectInt {

  private final Integer value;

  AutoValue_ObjectInt(
      Integer value) {
    this.value = value;
  }

  @javax.annotation.Nullable

  @Override
  Integer value() {
    return value;
  }

  @Override
  public String toString() {
    return "ObjectInt{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ObjectInt) {
      ObjectInt that = (ObjectInt) o;
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
