
package autojson.stream;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JsonLocation extends JsonLocation {

  private final long lineNumber;
  private final long columnNumber;
  private final long offset;

  AutoValue_JsonLocation(
      long lineNumber,
      long columnNumber,
      long offset) {
    this.lineNumber = lineNumber;
    this.columnNumber = columnNumber;
    this.offset = offset;
  }

  @Override
  public long getLineNumber() {
    return lineNumber;
  }

  @Override
  public long getColumnNumber() {
    return columnNumber;
  }

  @Override
  public long getOffset() {
    return offset;
  }

  @Override
  public String toString() {
    return "JsonLocation{"
        + "lineNumber=" + lineNumber + ", "
        + "columnNumber=" + columnNumber + ", "
        + "offset=" + offset
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof JsonLocation) {
      JsonLocation that = (JsonLocation) o;
      return (this.lineNumber == that.getLineNumber())
           && (this.columnNumber == that.getColumnNumber())
           && (this.offset == that.getOffset());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (lineNumber >>> 32) ^ lineNumber;
    h *= 1000003;
    h ^= (columnNumber >>> 32) ^ columnNumber;
    h *= 1000003;
    h ^= (offset >>> 32) ^ offset;
    return h;
  }

}
