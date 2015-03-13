
package autojson.integration;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ObjectNestedAutoJsonMulti extends ObjectNestedAutoJsonMulti {

  private final ObjectString stringValue;
  private final PrimitiveInt intValue;
  private final long longValue;

  AutoValue_ObjectNestedAutoJsonMulti(
      ObjectString stringValue,
      PrimitiveInt intValue,
      long longValue) {
    if (stringValue == null) {
      throw new NullPointerException("Null stringValue");
    }
    this.stringValue = stringValue;
    if (intValue == null) {
      throw new NullPointerException("Null intValue");
    }
    this.intValue = intValue;
    this.longValue = longValue;
  }

  @Override
  ObjectString stringValue() {
    return stringValue;
  }

  @Override
  PrimitiveInt intValue() {
    return intValue;
  }

  @Override
  long longValue() {
    return longValue;
  }

  @Override
  public String toString() {
    return "ObjectNestedAutoJsonMulti{"
        + "stringValue=" + stringValue + ", "
        + "intValue=" + intValue + ", "
        + "longValue=" + longValue
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ObjectNestedAutoJsonMulti) {
      ObjectNestedAutoJsonMulti that = (ObjectNestedAutoJsonMulti) o;
      return (this.stringValue.equals(that.stringValue()))
           && (this.intValue.equals(that.intValue()))
           && (this.longValue == that.longValue());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= stringValue.hashCode();
    h *= 1000003;
    h ^= intValue.hashCode();
    h *= 1000003;
    h ^= (longValue >>> 32) ^ longValue;
    return h;
  }

}
