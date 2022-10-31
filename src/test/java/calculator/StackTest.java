package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for {@link calculator.Stack}.
 * 
 * @author wjis132
 *
 */
public class StackTest {

  /**
   * Test method for {@link calculator.Stack#size()}.
   */
  @Test
  public void testSize() {
    // create new empty stack testStack
    Stack testStack = new Stack();
    // stack size returned should be 0
    assertEquals(0, testStack.size());

  }

  /**
   * Test method for {@link calculator.Stack#push(calculator.Entry)}.
   */
  @Test
  public void testPush() {
    // create new empty stack testStack
    Stack testStack = new Stack();
    // push a new entry to testStack
    testStack.push(new Entry());
    // stack size returned should be 1
    assertEquals(1, testStack.size());
    // push another entry to testStack
    testStack.push(new Entry());
    // stack size returned should be 1
    assertEquals(2, testStack.size());

  }

  @Test
  public void testPushMany() {
    // create new empty stack testStack
    Stack testStack = new Stack();

    // push 100 items (0-100) into the stack
    for (int i = 1; i <= 100; i++) {
      testStack.push(new Entry(i));
    }

    // after 100 push, size should be 100
    assertEquals(100, testStack.size());
    try {
      // after pushing last entry (100) in loop, getting top value in stack should be 100
      assertEquals(100, testStack.top().getValue());
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test method for {@link calculator.Stack#pop()}.
   */
  @Test
  public void testEmptyPop() {
    // create new empty stack testStack
    Stack testStack = new Stack();

    // pop from empty stack should throw exception
    assertThrows(EmptyStackException.class, () -> {
      testStack.pop();
    });

  }

  @Test
  public void testPushPop() {

    // create new empty stack testStack, new entry testEntry
    Stack testStack = new Stack();
    Entry testEntry = new Entry(3.14f);
    // push a new testEntry to testStack
    testStack.push(testEntry);

    // stack size returned should be 1
    assertEquals(1, testStack.size());

    // pop entry from testStack, should return top entry
    assertEquals(testEntry, testStack.pop());

    // stack size should now be 0
    assertEquals(0, testStack.size());


  }

  /**
   * Test method for {@link calculator.Stack#top()}.
   */
  @Test
  public void testEmptyTop() {
    // create new empty stack testStack
    Stack testStack = new Stack();

    // top from empty stack should throw exception
    assertThrows(EmptyStackException.class, () -> {
      testStack.top();
    });
  }

  @Test
  public void testPushTop() {
    // create new empty stack testStack, new entry testEntry
    Stack testStack = new Stack();
    Entry testEntry = new Entry(3.14f);

    // push a new testEntry to testStack
    testStack.push(testEntry);
    // stack size returned should be 1
    assertEquals(1, testStack.size());

    // pop entry from testStack, should return top entry
    assertEquals(testEntry, testStack.top());

    // stack size should still be 1 because no entry should be popped from the stack
    assertEquals(1, testStack.size());


  }

}
