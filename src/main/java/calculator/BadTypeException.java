package calculator;

/**
 * This exception is thrown when an {@link calculator.Entry} getter does not match the constructor.
 * 
 * @author wjis132
 */
public class BadTypeException extends Exception {
  private static final long serialVersionUID = 1L;

  /**
   * Constructor of {@link calculator.BadTypeException} with a String message.
   * 
   * @param message The error message when the exception is thrown
   */
  public BadTypeException(String message) {
    super(message);
  }
}
