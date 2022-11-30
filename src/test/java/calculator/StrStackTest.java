package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for {@link calculator.StrStack}.
 * 
 * @author wjis132
 *
 */
public class StrStackTest {

  /**
   * Test method for {@link calculator.StrStack#isEmpty()}.
   */
  @Test
  public void testIsEmpty() {
    StrStack testStrStack = new StrStack();
    assertEquals(true, testStrStack.isEmpty());
  }

  /**
   * Test method for {@link calculator.StrStack#push(Symbol)}.
   */
  @Test
  public void testPush() {
    // create new empty StrStack testStrStack
    StrStack testStrStack = new StrStack();
    // push a new Symbol to testStack
    testStrStack.push("3.14");

    // StrStack should not be empty after push
    assertEquals(false, testStrStack.isEmpty());
  }

  /**
   * Test method for {@link calculator.StrStack#pop()}.
   */
  @Test
  public void testEmptyPop() {
    // create new empty StrStack testStrStack
    StrStack testStrStack = new StrStack();
    // Empty StrStack should throw EmptyStackException
    assertThrows(EmptyStackException.class, () -> {
      testStrStack.pop();
    });
  }

  /**
   * Test method for {@link calculator.StrStack#pop()}.
   */
  @Test
  public void testPushPop() {
    // create new empty StrStack testStrStack
    StrStack testStrStack = new StrStack();
    // push a new float to testStack
    testStrStack.push("3.14");

    // pop entry from testNumStack, should return top entry
    assertEquals("3.14", testStrStack.pop());

    // stack size should be 0 after pop
    assertEquals(true, testStrStack.isEmpty());
  }

}
