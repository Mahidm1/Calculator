package uk.ac.rhul.cs2800;

/**
 * The {@code Symbol} enum represents different mathematical symbols, including left bracket, right
 * bracket, multiplication, division, addition, subtraction, and an Invalid symbol.
 */
public enum Symbol {
  /**
   * Represents a left bracket symbol "(".
   */
  LEFT_BRACKET("("),

  /**
   * Represents a right bracket symbol ")".
   */
  RIGHT_BRACKET(")"),

  /**
   * Represents a multiplication symbol "*".
   */
  TIME("*"),

  /**
   * Represents a division symbol "/".
   */
  DIVIDE("/"),

  /**
   * Represents an addition symbol "+".
   */
  PLUS("+"),

  /**
   * Represents a subtraction symbol "-".
   */
  MINUS("-"),

  /**
   * Represents an Invalid symbol, which can be used when no valid symbol is present.
   */
  INVALID("Invalid");

  private final String symbol;

  /**
   * Creates a new Symbol enum value with the specified symbol.
   *
   * @param symbol The string representation of the symbol.
   */
  Symbol(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Get the string representation of the symbol.
   *
   * @return The string representation of the symbol.
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * Returns the string representation of the symbol, which is the same as calling getSymbol().
   *
   * @return The string representation of the symbol.
   */
  @Override
  public String toString() {
    return getSymbol();
  }
}
