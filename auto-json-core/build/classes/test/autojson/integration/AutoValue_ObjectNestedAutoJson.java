
package autojson.integration;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ObjectNestedAutoJson extends ObjectNestedAutoJson {

  private final ObjectString value;

  AutoValue_ObjectNestedAutoJson(
      ObjectString value) {
    this.value = value;
  }

  @javax.annotation.Nullable

  @Override
  ObjectString value() {
    return value;
  }

  @Override
  public String toString() {
    return "ObjectNestedAutoJson{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ObjectNestedAutoJson) {
      ObjectNestedAutoJson that = (ObjectNestedAutoJson) o;
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
