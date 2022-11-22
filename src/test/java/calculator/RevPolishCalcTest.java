package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {

  private RevPolishCalc rpCalc;

  @BeforeEach
  void newRevPolishCalc() {
    this.rpCalc = new RevPolishCalc();
  }

  @Test
  void testEvaluateNull() {
    // Entering null as expression should throw InvalidExpressionException
    assertThrows(EmptyStackException.class, () -> {
      this.rpCalc.evaluate(null);
    });
  }

  @Test
  void testEvaluateNumberOnly() {
    // Entering only one number should return same number
    assertEquals(0, this.rpCalc.evaluate("0"));
  }

  @Test
  void testEvaluateAdd() {
    // Entering a simple addition should return correct result
    assertEquals(1 + 2, this.rpCalc.evaluate("1 2 +"));
  }

  @Test
  void testEvaluateSubtract() {
    // Entering a simple subtraction should return correct result
    assertEquals(1 - 2, this.rpCalc.evaluate("1 2 -"));
  }

  @Test
  void testEvaluateMultiply() {
    // Entering a simple multiplication should return correct result
    assertEquals(1 * 2, this.rpCalc.evaluate("1 2 *"));
  }

  @Test
  void testEvaluateDivide() {
    // Entering a simple division should return correct result
    assertEquals(1 / 2, this.rpCalc.evaluate("1 2 /"));
  }

  @Test
  void testEvaluateAddTwice() {
    // Two additions should be evaluated in order
    assertEquals(1 + 2 + 3, this.rpCalc.evaluate("1 2 + 3 +"));
  }

  @Test
  void testEvaluateSubtractTwice() {
    // Two subtractions should be evaluated in order
    assertEquals(1 - 2 - 3, this.rpCalc.evaluate("1 2 - 3 -"));
  }

  @Test
  void testEvaluateMultiplyTwice() {
    // Two multiplications should be evaluated in order
    assertEquals(1 * 2 * 3, this.rpCalc.evaluate("1 2 * 3 *"));
  }

  @Test
  void testEvaluateDivideTwice() {
    // Two additions should be evaluated in order
    assertEquals(1 / 2 / 3, this.rpCalc.evaluate("1 2 / 3 /"));
  }

  @Test
  void testEvaluateAddMultiply() {
    // Add before Multiplication
    assertEquals((1 + 2) * 3, this.rpCalc.evaluate("1 2 + 3 *"));
  }

  @Test
  void testEvaluateAddDivide() {
    // Add before division
    assertEquals((1 + 2) / 3, this.rpCalc.evaluate("1 2 + 3 /"));
  }

  @Test
  void testEvaluateMultipleOp() {
    // Test Multiple operations in Reverse Polish Expression as in the example 
    assertEquals((5 * (6 + 7)) - 2, this.rpCalc.evaluate("5 6 7 + * 2 -"));
    assertEquals(63, this.rpCalc.evaluate("5 6 7 + * 2 -"));
  }


}
