package uk.ac.rhul.cs2800;

/**
 * The {@code Type} enum represents different types that can be associated with an Entry. These
 * types include String, Number, Symbol, and Invalid.
 */
public enum Type {
  /**
   * Represents a String type.
   */
  STRING("String"),

  /**
   * Represents a Number type.
   */
  NUMBER("Number"),

  /**
   * Represents a Symbol type.
   */
  SYMBOL("Symbol"),

  /**
   * Represents an Invalid type, which can be used when no valid type is present.
   */
  INVALID("Invalid");

  private final String typeValue;

  /**
   * Creates a new Type enum value with the specified type value.
   *
   * @param typeValue The string representation of the type.
   */
  Type(String typeValue) {
    this.typeValue = typeValue;
  }

  /**
   * Get the string representation of the type.
   *
   * @return The string representation of the type.
   */
  public String gettypeValue() {
    return typeValue;
  }

  /**
   * Returns the string representation of the type, which is the same as calling gettypeValue().
   *
   * @return The string representation of the type.
   */
  @Override
  public String toString() {
    return gettypeValue();
  }
}
