package calculator;

/**
 * Calculator Model for use in CalcController.
 * 
 * @author wjis132
 */
public class CalcModel {

  private final RevPolishCalc revPolish = new RevPolishCalc();
  private final StandardCalc standard = new StandardCalc();

  /**
   * Accepts in a string expression and calculates the result using infix or reverse polish based on
   * a boolean.
   * 
   * @param expr Expression to be calculated
   * @param infix Determines whether the expression is infix or reverse polish
   * @return float Returns the result of the calculation
   * @throws InvalidExpressionException Passes the {@link calculator.InvalidExpressionException}
   *         thrown by {@link calculator.CalcModel#standard} or
   *         {@link calculator.CalcModel#revPolish}.
   */
  public float evaluate(String expr, boolean infix) throws InvalidExpressionException {
    // If infix is true, evaluate with standard infix, if not, evaluate with reverse polish
    return infix ? standard.evaluate(expr) : revPolish.evaluate(expr);
  }
}
