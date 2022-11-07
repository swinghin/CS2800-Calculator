package calculator;

/**
 * This class is used as values stored in a {@link calculator.Stack}.
 * 
 * @author wjis132
 */

public class Entry {


  /**
   * Variables to store values when instantiated.
   */
  private float number;
  private Symbol other;
  private String str;

  /**
   * The variable that stores and determines the type of value stored in the
   * {@link calculator.Entry} object.
   */
  private Type type;

  /**
   * A constructor that creates a new {@link calculator.Entry} with a float value and sets type to
   * {@link calculator.Type#NUMBER}.
   * 
   * @param value A float value.
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * A constructor that creates a new {@link calculator.Entry} with a {@link calculator.Symbol}
   * value and sets type to {@link calculator.Type#SYMBOL}.
   * 
   * @param which A Symbol enum.
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * A constructor that creates a new {@link calculator.Entry} with string value and sets type to
   * {@link calculator.Type#STRING}.
   * 
   * @param str A String value.
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Default constructor that creates an {@link calculator.Entry} with
   * {@link calculator.Type#INVALID}.
   */
  public Entry() {
    this.type = Type.INVALID;
  }

  /**
   * Returns the type of the Entry as a {@link calculator.Type}.
   * 
   * @return type The {@link calculator.Entry} type.
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the string value in the {@link calculator.Entry} if the {@link calculator.Entry} is a
   * {@link calculator.Type#STRING} type. Throws {@link calculator.BadTypeException} when
   * {@link calculator.Entry}'s {@link calculator.Type} is not string.
   * 
   * @return str Returns the string value of this {@link calculator.Entry}.
   * @throws BadTypeException Thrown when the {@link calculator.Entry} {@link calculator.Type} is
   *         not {@link calculator.Type#STRING}.
   */
  public String getString() throws BadTypeException {
    if (this.getType() != Type.STRING) {
      throw new BadTypeException("Exception: BadType");
    } else {
      return str;
    }
  }

  /**
   * Returns the string value in the Entry if the {@link calculator.Entry} is a
   * {@link calculator.Type#SYMBOL} type. Throws {@link calculator.BadTypeException} when
   * {@link calculator.Entry} {@link calculator.Type} is not {@link calculator.Symbol}.
   * 
   * @return other Returns the {@link calculator.Symbol} of this {@link calculator.Entry}
   * @throws BadTypeException Thrown when the {@link calculator.Entry} {@link calculator.Type} is
   *         not {@link calculator.Type#SYMBOL}.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.getType() != Type.SYMBOL) {
      throw new BadTypeException("Exception: BadType");
    } else {
      return other;
    }
  }

  /**
   * Returns the string value in the {@link calculator.Entry} if the {@link calculator.Entry} is a
   * {@link calculator.Type#NUMBER} type. Throws {@link calculator.BadTypeException} when
   * {@link calculator.Entry} {@link calculator.Type} is not number.
   * 
   * @return value Returns the float value of this {@link calculator.Entry}
   * @throws BadTypeException Thrown when the {@link calculator.Entry} {@link calculator.Type} is
   *         not {@link calculator.Type#NUMBER}.
   */
  public float getValue() throws BadTypeException {
    if (this.getType() != Type.NUMBER) {
      throw new BadTypeException("Exception: BadType");
    } else {
      return number;
    }
  }


  /**
   * Returns a reasonable hash value of the {@link calculator.Entry}.
   */
  @Override
  public int hashCode() {
    // auto generated hash code function by Eclipse
    final int prime = 31;
    int result = 1;
    result = prime * result + ((str == null) ? 0 : str.hashCode());
    return result;
  }

  /**
   * Two entries should be considered equal if and only if they have the same type and value (same
   * text in Strings).
   */
  @Override
  public boolean equals(Object obj) {

    Entry other = (Entry) obj;

    // return not equal if type is different
    if (this.type != other.type) {
      return false;
    }

    // if type is equal, then compare values based on entry type
    switch (this.type) {
      case NUMBER:
        return this.number == other.number;
      case SYMBOL:
        return this.other == other.other;
      case STRING:
        return this.str == other.str;
      default:
        return false;
    }

  }

  /**
   * Returns a human readable string representation of the {@link calculator.Entry} with type and
   * value.
   * 
   * @return string String representation of the {@link calculator.Entry}.
   */
  @Override
  public String toString() {
    // based on entry type, return appropriate entry value
    switch (this.type) {
      case NUMBER:
        return String.valueOf(number);
      case SYMBOL:
        return String.valueOf(other);
      case STRING:
        return str;
      default:
        return type.toString();
    }
  }
}
