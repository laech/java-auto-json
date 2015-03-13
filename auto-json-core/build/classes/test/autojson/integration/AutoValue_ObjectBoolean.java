
package autojson.integration;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ObjectBoolean extends ObjectBoolean {

  private final Boolean value;

  AutoValue_ObjectBoolean(
      Boolean value) {
    this.value = value;
  }

  @javax.annotation.Nullable

  @Override
  Boolean value() {
    return value;
  }

  @Override
  public String toString() {
    return "ObjectBoolean{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ObjectBoolean) {
      ObjectBoolean that = (ObjectBoolean) o;
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
