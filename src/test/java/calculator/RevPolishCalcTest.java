package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {

  private RevPolishCalc rpCalc;

  /**
   * Initialises {@link RevPolishCalc.rpCalc} before each test.
   */
  @BeforeEach
  void newRevPolishCalc() {
    this.rpCalc = new RevPolishCalc();
  }

  /**
   * Test 1: Evaluate null as expression
   */
  @Test
  void testEvaluateNull() {
    // Entering null as expression should throw InvalidExpressionException
    assertThrows(InvalidExpressionException.class, () -> {
      this.rpCalc.evaluate(null);
    });
  }

  /**
   * Test 2: Evaluate expression with single number only
   */
  @Test
  void testEvaluateNumberOnly() {
    // Entering only one number should return same number
    try {
      assertEquals(1, this.rpCalc.evaluate("1"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 3: Evaluate expression with simple addition
   */
  @Test
  void testEvaluateAdd() {
    // Entering a simple addition should return correct result
    try {
      assertEquals(1 + 2, this.rpCalc.evaluate("1 2 +"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 4: Evaluate expression with simple subtraction
   */
  @Test
  void testEvaluateSubtract() {
    // Entering a simple subtraction should return correct result
    try {
      assertEquals(1 - 2, this.rpCalc.evaluate("1 2 -"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 5: Evaluate expression with simple multiplication
   */
  @Test
  void testEvaluateMultiply() {
    // Entering a simple multiplication should return correct result
    try {
      assertEquals(1 * 2, this.rpCalc.evaluate("1 2 *"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 6: Evaluate expression with simple division
   */
  @Test
  void testEvaluateDivide() {
    // Entering a simple division should return correct result
    try {
      assertEquals(1f / 2f, this.rpCalc.evaluate("1 2 /"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 7: Evaluate expression with two additions
   */
  @Test
  void testEvaluateAddTwice() {
    // Two additions should be evaluated in order
    try {
      assertEquals(1 + 2 + 3, this.rpCalc.evaluate("1 2 + 3 +"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 8: Evaluate expression with two subtractions
   */
  @Test
  void testEvaluateSubtractTwice() {
    // Two subtractions should be evaluated in order
    try {
      assertEquals(1 - 2 - 3, this.rpCalc.evaluate("1 2 - 3 -"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 9: Evaluate expression with two multiplications
   */
  @Test
  void testEvaluateMultiplyTwice() {
    // Two multiplications should be evaluated in order
    try {
      assertEquals(1 * 2 * 3, this.rpCalc.evaluate("1 2 * 3 *"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 10: Evaluate expression with two divisions
   */
  @Test
  void testEvaluateDivideTwice() {
    // Two additions should be evaluated in order
    try {
      assertEquals(1f / 2f / 3f, this.rpCalc.evaluate("1 2 / 3 /"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 11: Evaluate expression with addition then multiplication
   */
  @Test
  void testEvaluateAddMultiply() {
    // Add before Multiplication
    try {
      assertEquals((1 + 2) * 3, this.rpCalc.evaluate("1 2 + 3 *"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 12: Evaluate expression with addition then division
   */
  @Test
  void testEvaluateAddDivide() {
    // Add before division
    try {
      assertEquals((1 + 2) / 3f, this.rpCalc.evaluate("1 2 + 3 /"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 13: Evaluate expression with multiple operations
   */
  @Test
  void testEvaluateMultipleOp() {
    try {
      // Test Multiple operations in Reverse Polish Expression as in the example
      assertEquals((5 * (6 + 7)) - 2, this.rpCalc.evaluate("5 6 7 + * 2 -"));
      assertEquals(63, this.rpCalc.evaluate("5 6 7 + * 2 -"));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 14: Evaluate expression with less than 2 operands
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
   * Test 15: Evaluate expression with invalid operator
   */
  @Test
  void testEvaluateInvalidOp() {
    // rpCalc should throw exception when there is invalid symbols i.e. brackets
    assertThrows(InvalidExpressionException.class, () -> {
      this.rpCalc.evaluate("(");
    });
  }


}
