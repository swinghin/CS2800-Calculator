package calculator;

import java.util.EmptyStackException;

/**
 * This is a facade class that holds Strings in a {@link calculator.Stack} and hides the details of
 * the {@link calculator.Stack} class.
 * 
 * @author wjis132
 *
 */
public class StrStack {

  /**
   * {@link calculator.Stack} that stores {@link calculator.Entry}s of strings.
   */
  private Stack strStack;

  /**
   * Default constructor for {@link calculator.StrStack} class that initialises the
   * {@link calculator.StrStack#strStack} as a {@link calculator.Stack}.
   */
  public StrStack() {
    this.strStack = new Stack();
  }

  /**
   * Accepts a String and adds it as an {@link calculator.Entry} to the
   * {@link calculator.StrStack#strStack}.
   * 
   * @param i String value to be pushed into {@link calculator.StrStack#strStack}
   */
  public void push(String i) {
    this.strStack.push(new Entry(i));
  }

  /**
   * Pops an {@link calculator.Entry} from {@link calculator.OpStack#opStack} and returns the String
   * from the {@link calculator.Entry}.
   * 
   * @return String The String of the top {@link calculator.Entry} from
   *         {@link calculator.StrStack#strStack}.
   * @throws EmptyStackException Throws EmptyStackException when
   *         {@link calculator.StrStack#strStack} is empty.
   */
  public String pop() {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    } else {
      try {
        return this.strStack.pop().getString();
      } catch (BadTypeException e) {
        e.printStackTrace();
      }
      return "";
    }
  }

  /**
   * Returns true if the {@link calculator.StrStack#strStack} is empty, false if it is not empty.
   * 
   * @return Boolean
   */
  public Boolean isEmpty() {
    return this.strStack.size() == 0 ? true : false;
  }
}
