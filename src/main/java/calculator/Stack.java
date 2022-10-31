package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * This class represents a {@link calculator.Stack} of {@link calculator.Entry} values.
 * 
 * @author wjis132
 */
public class Stack {

  private int size;
  private List<Entry> entries;

  /**
   * Default constructor for {@link calculator.Stack} class that initialises the entries ArrayList.
   */
  public Stack() {
    this.entries = new ArrayList<Entry>();
  }

  /**
   * Accepts an {@link calculator.Entry} object and adds it to the entries ArrayList and increments
   * the size variable.
   * 
   * @param i Entry object to be pushed into the stack.
   */
  public void push(Entry i) {
    this.entries.add(i);
    this.size++;
  }

  /**
   * Gets the top {@link calculator.Entry} from the stack, removes it from the stack and returns it.
   * 
   * @return Entry The top {@link calculator.Entry} from the stack.
   */
  public Entry pop() {
    if (this.size == 0) {
      throw new EmptyStackException();
    } else {
      Entry tempEntry = this.entries.get(this.size - 1);
      this.entries.remove(this.size - 1);
      this.size--;
      return tempEntry;
    }
  }

  /**
   * Returns the top {@link calculator.Entry} from the stack.
   * 
   * @return Entry The top {@link calculator.Entry} from the stack.
   */
  public Entry top() {
    if (this.size == 0) {
      throw new EmptyStackException();
    } else {
      return this.entries.get(this.size - 1);
    }
  }

  /**
   * Returns the current size of the stack.
   * 
   * @return size The current size of the stack.
   */
  public int size() {
    return this.size;
  }
}
