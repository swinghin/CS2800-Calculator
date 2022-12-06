package calculator;

import java.util.function.Consumer;

/**
 * View Interface for AsciiView and GuiView.
 * 
 * @author wjis132
 */
public interface ViewInterface {

  /**
   * Gets the string expression from text field.
   * 
   * @return expression
   */
  public String getExpression();

  /**
   * Sets str to answer text field.
   * 
   * @param str The answer as a string.
   */
  public void setAnswer(String str);

  /**
   * Adds calc button observer.
   */
  public void addCalcObserver();

  /**
   * Adds type observer.
   */
  public void addTypeObserver();
}
