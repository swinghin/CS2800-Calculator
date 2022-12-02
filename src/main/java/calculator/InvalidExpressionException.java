package calculator;

/**
 * This exception is thrown when an {@link calculator.Calculator#evaluate(String)} encounters an
 * invalid expression.
 * 
 * @author wjis132
 */
public class InvalidExpressionException extends Exception {
  private static final long serialVersionUID = 1L;

  /**
   * Constructor of {@link calculator.InvalidExpressionException} with a String message.
   * 
   * @param message The error message when the exception is thrown
   */
  public InvalidExpressionException(String message) {
    super(message);
  }
}
