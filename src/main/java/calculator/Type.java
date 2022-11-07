package calculator;

/**
 * A list of the types of value an {@link calculator.Entry} can represent.
 * 
 * @author wjis132
 */
public enum Type {
  NUMBER, SYMBOL, STRING, INVALID;

  /**
   * Returns a human readable string representation of the {@link calculator.Entry} Type in lower
   * case.
   */
  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
