

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ObjectInDefaultPackage extends ObjectInDefaultPackage {

  private final String value;

  AutoValue_ObjectInDefaultPackage(
      String value) {
    if (value == null) {
      throw new NullPointerException("Null value");
    }
    this.value = value;
  }

  @Override
  String value() {
    return value;
  }

  @Override
  public String toString() {
    return "ObjectInDefaultPackage{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ObjectInDefaultPackage) {
      ObjectInDefaultPackage that = (ObjectInDefaultPackage) o;
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
