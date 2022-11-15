package calculator;

import java.util.EmptyStackException;

/**
 * This is a facade class that holds numeric values in a {@link calculator.Stack} and hides the
 * details of the {@link calculator.Stack} class.
 * 
 * @author wjis132
 *
 */
public class NumStack {

  private Stack numStack;

  /**
   * Default constructor for {@link calculator.NumStack} class that initialises the
   * {@link calculator.NumStack#numStack} as a {@link calculator.Stack}.
   */
  public NumStack() {
    this.numStack = new Stack();
  }

  /**
   * Accepts a numeric value and adds it to the {@link calculator.NumStack#numStack}.
   * 
   * @param i Numeric value to be pushed into {@link calculator.NumStack#numStack}
   */
  public void push(float i) {
    this.numStack.push(new Entry(i));
  }

  /**
   * Gets the top {@link calculator.Entry} from {@link calculator.NumStack#numStack} removes it by
   * calling pop(), get the numeric value from the {@link calculator.Entry} and returns it.
   * 
   * @return float The top numeric value from {@link calculator.NumStack#numStack} as float.
   * @throws EmptyStackException Throws EmptyStackException when
   *         {@link calculator.NumStack#numStack} is empty.
   */
  public float pop() {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    } else {
      try {
        return this.numStack.pop().getValue();
      } catch (BadTypeException e) {
        e.printStackTrace();
      }
      return 0;
    }
  }

  /**
   * Returns true if the {@link calculator.NumStack#numStack} is empty, false if it is not empty.
   * 
   * @return Boolean
   */
  public Boolean isEmpty() {
    return this.numStack.size() == 0 ? true : false;
  }
}
