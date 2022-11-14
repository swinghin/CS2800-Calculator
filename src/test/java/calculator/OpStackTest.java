package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for {@link calculator.OpStack}.
 * 
 * @author wjis132
 *
 */
public class OpStackTest {

  /**
   * Test method for {@link calculator.OpStack#isEmpty()}.
   */
  @Test
  public void testIsEmpty() {
    OpStack testOpStack = new OpStack();
    assertEquals(true, testOpStack.isEmpty());
  }

  /**
   * Test method for {@link calculator.OpStack#push(Symbol)}.
   */
  @Test
  public void testPush() {
    // create new empty OpStack testOpStack
    OpStack testOpStack = new OpStack();
    // push a new Symbol to testStack
    testOpStack.push(Symbol.PLUS);

    // OpStack should not be empty after push
    assertEquals(false, testOpStack.isEmpty());
  }

  /**
   * Test method for {@link calculator.OpStack#pop()}.
   */
  @Test
  public void testEmptyPop() {
    // create new empty OpStack testOpStack
    OpStack testOpStack = new OpStack();
    // Empty opStack should throw EmptyStackException
    assertThrows(EmptyStackException.class, () -> {
      testOpStack.pop();
    });
  }

  /**
   * Test method for {@link calculator.OpStack#pop()}.
   */
  @Test
  public void testPushPop() {
    // create new empty OpStack testOpStack
    OpStack testOpStack = new OpStack();
    // push a new float to testStack
    testOpStack.push(Symbol.PLUS);

    // pop entry from testOpStack, should return top entry
    assertEquals(Symbol.PLUS, testOpStack.pop());

    // stack size should be 0 after pop
    assertEquals(true, testOpStack.isEmpty());
  }

}
