
package autojson.integration.sub;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_CrossPackageObject extends CrossPackageObject {

  private final int value;

  AutoValue_CrossPackageObject(
      int value) {
    this.value = value;
  }

  @Override
  public int value() {
    return value;
  }

  @Override
  public String toString() {
    return "CrossPackageObject{"
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CrossPackageObject) {
      CrossPackageObject that = (CrossPackageObject) o;
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
