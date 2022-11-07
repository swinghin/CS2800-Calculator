package calculator;

/**
 * A list of the non-number tokens possible in an expression.
 * 
 * 
 * @author wjis132
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      null);

  
  private String symbol;

  private Symbol(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Returns a character representation of the {@link calculator.Symbol}.
   * 
   * @return symbol {@link calculator.Symbol} represented by a character.
   */
  @Override
  public String toString() {
    return this.symbol;
  }
}
