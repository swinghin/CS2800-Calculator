package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for {@link calculator.NumStack}.
 * 
 * @author wjis132
 *
 */
public class NumStackTest {

  /**
   * Test method for {@link calculator.NumStack#isEmpty()}.
   */
  @Test
  public void testIsEmpty() {
    NumStack testNumStack = new NumStack();
    assertEquals(true, testNumStack.isEmpty());
  }

  /**
   * Test method for {@link calculator.NumStack#push(float)}.
   */
  @Test
  public void testPush() {
    // create new empty NumStack testNumStack
    NumStack testNumStack = new NumStack();
    // push a new float to testStack
    testNumStack.push(3.14f);
    
    // NumStack should not be empty after push
    assertEquals(false, testNumStack.isEmpty());
  }

  /**
   * Test method for {@link calculator.NumStack#pop()}.
   */
  @Test
  public void testEmptyPop() {
    // create new empty NumStack testStack
    NumStack testNumStack = new NumStack();
    // Empty NumStack should throw EmptyStackException
    assertThrows(EmptyStackException.class, () -> {
      testNumStack.pop();
    });
  }

  /**
   * Test method for {@link calculator.NumStack#pop()}.
   */
  @Test
  public void testPushPop() {
    // create new empty NumStack testStack
    NumStack testNumStack = new NumStack();
    // push a new float to testStack
    testNumStack.push(3.14f);

    // pop entry from testNumStack, should return top entry
    assertEquals(3.14f, testNumStack.pop());

    // stack size should be 0 after pop
    assertEquals(true, testNumStack.isEmpty());
  }

}
