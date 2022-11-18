package calculator;

import java.util.EmptyStackException;

/**
 * This is a facade class that holds operator {@link calculator.Symbol}s in a
 * {@link calculator.Stack} and hides the details of the {@link calculator.Stack} class.
 * 
 * @author wjis132
 *
 */
public class OpStack {

  /**
   * {@link calculator.Stack} that stores {@link calculator.Entry}s of {@link calculator.Symbol}s.
   */
  private Stack opStack;

  /**
   * Default constructor for {@link calculator.OpStack} class that initialises the
   * {@link calculator.OpStack#opStack} as a {@link calculator.Stack}.
   */
  public OpStack() {
    this.opStack = new Stack();
  }

  /**
   * Accepts {@link calculator.Symbol} and adds it as an {@link calculator.Entry} to the
   * {@link calculator.OpStack#opStack}.
   * 
   * @param i {@link calculator.Symbol} to be pushed into {@link calculator.OpStack#opStack}
   */
  public void push(Symbol i) {
    this.opStack.push(new Entry(i));
  }

  /**
   * Pops an {@link calculator.Entry} from {@link calculator.OpStack#opStack} and returns the
   * {@link calculator.Symbol} from the {@link calculator.Entry}.
   * 
   * @return {@link calculator.Symbol} The {@link calculator.Symbol} of the top
   *         {@link calculator.Entry} from {@link calculator.NumStack#numStack}.
   * @throws EmptyStackException Throws EmptyStackException when {@link calculator.OpStack#opStack}
   *         is empty.
   */
  public Symbol pop() {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    } else {
      try {
        return this.opStack.pop().getSymbol();
      } catch (BadTypeException e) {
        e.printStackTrace();
      }
      return Symbol.INVALID;
    }
  }

  /**
   * Returns true if the {@link calculator.OpStack#opStack} is empty, false if it is not empty.
   * 
   * @return Boolean
   */
  public Boolean isEmpty() {
    return this.opStack.size() == 0 ? true : false;
  }
}
