
package autojson.integration;

import java.math.BigDecimal;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Primitives extends Primitives {

  private final int intValue;
  private final long longValue;
  private final BigDecimal decimalValue;
  private final boolean booleanValue;
  private final String stringValue;

  AutoValue_Primitives(
      int intValue,
      long longValue,
      BigDecimal decimalValue,
      boolean booleanValue,
      String stringValue) {
    this.intValue = intValue;
    this.longValue = longValue;
    if (decimalValue == null) {
      throw new NullPointerException("Null decimalValue");
    }
    this.decimalValue = decimalValue;
    this.booleanValue = booleanValue;
    if (stringValue == null) {
      throw new NullPointerException("Null stringValue");
    }
    this.stringValue = stringValue;
  }

  @Override
  int intValue() {
    return intValue;
  }

  @Override
  long longValue() {
    return longValue;
  }

  @Override
  BigDecimal decimalValue() {
    return decimalValue;
  }

  @Override
  boolean booleanValue() {
    return booleanValue;
  }

  @Override
  String stringValue() {
    return stringValue;
  }

  @Override
  public String toString() {
    return "Primitives{"
        + "intValue=" + intValue + ", "
        + "longValue=" + longValue + ", "
        + "decimalValue=" + decimalValue + ", "
        + "booleanValue=" + booleanValue + ", "
        + "stringValue=" + stringValue
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Primitives) {
      Primitives that = (Primitives) o;
      return (this.intValue == that.intValue())
           && (this.longValue == that.longValue())
           && (this.decimalValue.equals(that.decimalValue()))
           && (this.booleanValue == that.booleanValue())
           && (this.stringValue.equals(that.stringValue()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= intValue;
    h *= 1000003;
    h ^= (longValue >>> 32) ^ longValue;
    h *= 1000003;
    h ^= decimalValue.hashCode();
    h *= 1000003;
    h ^= booleanValue ? 1231 : 1237;
    h *= 1000003;
    h ^= stringValue.hashCode();
    return h;
  }

}
