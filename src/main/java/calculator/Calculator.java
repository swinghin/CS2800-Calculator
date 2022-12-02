package calculator;

/**
 * An interface for {@link calculator.RevPolishCalc} and {@link calculator.StandardCalc} to allow
 * calculation of String Expressions.
 * 
 * @author wjis132
 */
public interface Calculator {
  /**
   * Interface function for evaluating string expressions.
   * 
   * @param what String expression for evaluation.
   * @return float The result of the evaluation.
   * @throws InvalidExpressionException Thrown when the string expression is invalid.
   */
  public float evaluate(String what) throws InvalidExpressionException;
}
