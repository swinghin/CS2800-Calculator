package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    assertThrows(InvalidExpressionException.class, () -> {
      this.rpCalc.evaluate(null);
    });
  }

  @Test
  void testEvaluateNumberOnly() {
    // Entering only one number should return same number
    assertEquals(1, this.rpCalc.evaluate("1"));
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
    assertEquals(1f / 2f, this.rpCalc.evaluate("1 2 /"));
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
    assertEquals(1f / 2f / 3f, this.rpCalc.evaluate("1 2 / 3 /"));
  }

  @Test
  void testEvaluateAddMultiply() {
    // Add before Multiplication
    assertEquals((1 + 2) * 3, this.rpCalc.evaluate("1 2 + 3 *"));
  }

  @Test
  void testEvaluateAddDivide() {
    // Add before division
    assertEquals((1 + 2) / 3f, this.rpCalc.evaluate("1 2 + 3 /"));
  }

  @Test
  void testEvaluateMultipleOp() {
    // Test Multiple operations in Reverse Polish Expression as in the example
    assertEquals((5 * (6 + 7)) - 2, this.rpCalc.evaluate("5 6 7 + * 2 -"));
    assertEquals(63, this.rpCalc.evaluate("5 6 7 + * 2 -"));
  }

  /**
   * Test for {@link calculator.RevPolishCalc.evaluate} when there is inadequate operand(s)
   */
  @Test
  void testEvaluateInadequateOperand() {
    // rpCalc should throw exception when there is operation without operands
    assertThrows(InvalidExpressionException.class, () -> {
      this.rpCalc.evaluate("+");
    });
    // rpCalc should throw exception when there is only one operand for addition
    assertThrows(InvalidExpressionException.class, () -> {
      this.rpCalc.evaluate("1 +");
    });
  }

  /**
   * Test for {@link calculator.RevPolishCalc.evaluate} when there is inadequate operand(s)
   */
  @Test
  void testEvaluateInvalidOp() {
    // rpCalc should throw exception when there is invalid symbols i.e. brackets
    assertThrows(InvalidExpressionException.class, () -> {
      this.rpCalc.evaluate("(");
    });
  }


}
