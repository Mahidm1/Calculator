package application;

import java.util.Objects;

/**
 * Represents an entry that can have different types, including Number, String, and Symbol.
 */
public class Entry {

<<<<<<< HEAD
    private float number;
    private final Type type;
    private String str;
    private Symbol other;

    /**
     * Constructs a new Entry with a Number type and a numeric value.
     *
     * @param value The numeric value for this Entry.
     */
    public Entry(float value) {
        this.number = value;
        this.type = Type.NUMBER;
    }

    /**
     * Constructs a new Entry with a String type and a textual value.
     *
     * @param str The textual value for this Entry.
     */
    public Entry(String str) {
        this.str = str;
        this.type = Type.STRING;
    }

    /**
     * Constructs a new Entry with a Symbol type.
     *
     * @param which The Symbol representing this Entry.
     */
    public Entry(Symbol which) {
        this.other = which;
        this.type = Type.SYMBOL;
    }

    /**
     * Retrieves the Symbol associated with this Entry. Throws {@link BadType} if the type is not Symbol.
     *
     * @return The Symbol associated with this Entry.
     * @throws BadType If the type is not SYMBOL.
     */
    public Symbol getSymbol() {
        if (type != Type.SYMBOL) {
            throw new BadTypeException("Expected SYMBOL type, but found " + type);
        }
        return other;
    }

    /**
     * Retrieves the String associated with this Entry. Throws {@link BadType} if the type is not String.
     *
     * @return The String associated with this Entry.
     * @throws BadType If the type is not STRING.
     */
    public String getString() {
        if (type != Type.STRING) {
            throw new BadTypeException("Expected STRING type, but found " + type);
        }
        return str;
    }

    /**
     * Retrieves the Type of this Entry, which can be Number, String, or Symbol.
     *
     * @return The Type of this Entry.
     */
    public Type getType() {
        return type;
    }

    /**
     * Retrieves the numeric value associated with this Entry. Throws {@link BadType} if the type is not Number.
     *
     * @return The numeric value associated with this Entry.
     * @throws BadType If the type is not NUMBER.
     */
    public float getValue() {
        if (type != Type.NUMBER) {
            throw new BadTypeException("Expected NUMBER type, but found " + type);
        }
        return number;
    }

    /**
     * Checks if this Entry is equal to another object. Entries are considered equal if they have the same type and value.
     *
     * @param obj The object to compare to this Entry.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entry other = (Entry) obj;
        return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
                && this.other == other.other && Objects.equals(str, other.str) && type == other.type;
    }

    /**
     * Computes the hash code of this Entry.
     *
     * @return The hash code for this Entry.
     */
    @Override
    public int hashCode() {
        return Objects.hash(number, other, str, type);
    }
=======
  private float number;
  private final Type type;
  private String str;
  private Symbol other;

  /**
   * Constructs a new Entry with a Number type and a numeric value.
   *
   * @param value The numeric value for this Entry.
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Constructs a new Entry with a String type and a textual value.
   *
   * @param str The textual value for this Entry.
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Constructs a new Entry with a Symbol type.
   *
   * @param which The Symbol representing this Entry.
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Retrieves the Symbol associated with this Entry. Throws {@link BadType} if the type is not
   * Symbol.
   *
   * @return The Symbol associated with this Entry.
   * @throws BadType If the type is not SYMBOL.
   */
  public Symbol getSymbol() {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("Expected SYMBOL type, but found " + type);
    }
    return other;
  }

  /**
   * Retrieves the String associated with this Entry. Throws {@link BadType} if the type is not
   * String.
   *
   * @return The String associated with this Entry.
   * @throws BadType If the type is not STRING.
   */
  public String getString() {
    if (type != Type.STRING) {
      throw new BadTypeException("Expected STRING type, but found " + type);
    }
    return str;
  }

  /**
   * Retrieves the Type of this Entry, which can be Number, String, or Symbol.
   *
   * @return The Type of this Entry.
   */
  public Type getType() {
    return type;
  }

  /**
   * Retrieves the numeric value associated with this Entry. Throws {@link BadType} if the type is
   * not Number.
   *
   * @return The numeric value associated with this Entry.
   * @throws BadType If the type is not NUMBER.
   */
  public float getValue() {
    if (type != Type.NUMBER) {
      throw new BadTypeException("Expected NUMBER type, but found " + type);
    }
    return number;
  }

  /**
   * Checks if this Entry is equal to another object. Entries are considered equal if they have the
   * same type and value.
   *
   * @param obj The object to compare to this Entry.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && this.other == other.other && Objects.equals(str, other.str) && type == other.type;
  }

  /**
   * Computes the hash code of this Entry.
   *
   * @return The hash code for this Entry.
   */
  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }
>>>>>>> standardcalc
}
