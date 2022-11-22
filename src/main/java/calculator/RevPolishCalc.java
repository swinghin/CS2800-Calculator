package calculator;

/**
 * Evaluates Reverse Polish String Expressions.
 * 
 * @author wjis132
 */
public class RevPolishCalc implements Calculator {

  private NumStack values;

  /**
   * Constructor for {@link calculator.ReversePolishCalc} that intialises
   * {@link calculator.RevPolishCalc#values} as {@link calculator.NumStack}.
   */
  public RevPolishCalc() {}

  /**
   * Interface function for evaluating Reverse Polish string expressions.
   * 
   * @param what Reverse Polish string expressions for evaluation.
   * @return float The result of the evaluation.
   * @throws InvalidExpressionException Thrown when the string expression is invalid.
   */
  @Override
  public float evaluate(String what) {
    return 0;
  }

}
