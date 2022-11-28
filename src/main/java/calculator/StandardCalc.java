package calculator;

/**
 * Evaluates Reverse infix String Expressions.
 * 
 * @author wjis132
 */
public class StandardCalc implements Calculator {

  private NumStack values;

  /**
   * Constructor for {@link calculator.StandardCalc} that intialises
   * {@link calculator.RevPolishCalc#values} as {@link calculator.NumStack}.
   */
  public StandardCalc() {}

  /**
   * Interface function for evaluating standard infix string expressions.
   * 
   * @param what Standard infix string expressions for evaluation.
   * @return float The result of the evaluation.
   * @throws InvalidExpressionException Thrown when the string expression is invalid.
   */
  @Override
  public float evaluate(String what) throws InvalidExpressionException {
    return 0;
  }

}
