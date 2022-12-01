package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcModelTest {

  private CalcModel cModel;

  @BeforeEach
  void newCalcModel() {
    cModel = new CalcModel();
  }

  /**
   * Test 1: Evaluate infix expressions (adapted from StandardCalcTest)
   */
  @Test
  void testEvaluateInfix() {
    try {
      // Entering only one number should return same number
      assertEquals(1, this.cModel.evaluate("1", true));
      // Entering a simple addition should return correct result
      assertEquals(1 + 2, this.cModel.evaluate("1 + 2", true));
      // Entering a simple subtraction should return correct result
      assertEquals(1 - 2, this.cModel.evaluate("1 - 2", true));
      // Entering a simple multiplication should return correct result
      assertEquals(1 * 2, this.cModel.evaluate("1 * 2", true));
      // Entering a simple division should return correct result
      assertEquals(1f / 2f, this.cModel.evaluate("1 / 2", true));
      // Two additions should be evaluated in order
      assertEquals(1 + 2 + 3, this.cModel.evaluate("1 + 2 + 3", true));
      // Two subtractions should be evaluated in order
      assertEquals(1 - 2 - 3, this.cModel.evaluate("1 - 2 - 3", true));
      // Two multiplications should be evaluated in order
      assertEquals(1 * 2 * 3, this.cModel.evaluate("1 * 2 * 3", true));
      // Two divisions should be evaluated in order
      assertEquals(1f / 2f / 3f, this.cModel.evaluate("1 / 2 / 3", true));
      // Add before Multiplication
      assertEquals((1 + 2) * 3, this.cModel.evaluate("( 1 + 2 ) * 3", true));
      // Add before division
      assertEquals((1 + 2) / 3f, this.cModel.evaluate("( 1 + 2 ) / 3", true));
      // Test Multiple operations in Reverse Polish Expression as in the example
      assertEquals((5 * (6 + 7)) - 2, this.cModel.evaluate("( 5 * ( 6 + 7 ) ) - 2", true));
      assertEquals(63, this.cModel.evaluate("( 5 * ( 6 + 7 ) ) - 2", true));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 2: Evaluate invalid expressions (adapted from StandardCalcTest)
   */
  @Test
  void testEvaluateInfixException() {
    // Entering null as expression should throw InvalidExpressionException
    assertThrows(InvalidExpressionException.class, () -> {
      this.cModel.evaluate(null, true);
    });
    // cModel should throw exception when there is operation without operands
    assertThrows(InvalidExpressionException.class, () -> {
      this.cModel.evaluate("+", true);
    });
    // cModel should throw exception when there is only one operand for addition
    assertThrows(InvalidExpressionException.class, () -> {
      this.cModel.evaluate("1 +", true);
    });
    // cModel should throw exception when there is invalid symbols i.e. pound sign
    assertThrows(InvalidExpressionException.class, () -> {
      this.cModel.evaluate("£", true);
    });
  }

  /**
   * Test 3: Evaluate reverse polish expressions (adapted from RevPolishCalcTest)
   */
  @Test
  void testEvaluateRevPolish() {
    try {
      // Entering only one number should return same number
      assertEquals(1, this.cModel.evaluate("1", false));
      // Entering a simple addition should return correct result
      assertEquals(1 + 2, this.cModel.evaluate("1 2 +", false));
      // Entering a simple subtraction should return correct result
      assertEquals(1 - 2, this.cModel.evaluate("1 2 -", false));
      // Entering a simple multiplication should return correct result
      assertEquals(1 * 2, this.cModel.evaluate("1 2 *", false));
      // Entering a simple division should return correct result
      assertEquals(1f / 2f, this.cModel.evaluate("1 2 /", false));
      // Two additions should be evaluated in order
      assertEquals(1 + 2 + 3, this.cModel.evaluate("1 2 + 3 +", false));
      // Two subtractions should be evaluated in order
      assertEquals(1 - 2 - 3, this.cModel.evaluate("1 2 - 3 -", false));
      // Two multiplications should be evaluated in order
      assertEquals(1 * 2 * 3, this.cModel.evaluate("1 2 * 3 *", false));
      // Two divisions should be evaluated in order
      assertEquals(1f / 2f / 3f, this.cModel.evaluate("1 2 / 3 /", false));
      // Add before Multiplication
      assertEquals((1 + 2) * 3, this.cModel.evaluate("1 2 + 3 *", false));
      // Add before division
      assertEquals((1 + 2) / 3f, this.cModel.evaluate("1 2 + 3 /", false));
      // Test Multiple operations in Reverse Polish Expression as in the example
      assertEquals((5 * (6 + 7)) - 2, this.cModel.evaluate("5 6 7 + * 2 -", false));
      assertEquals(63, this.cModel.evaluate("5 6 7 + * 2 -", false));
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test 4: Evaluate invalid expressions (adapted from RevPolishTest)
   */
  @Test
  void testEvaluateRevPolishException() {
    // Entering null as expression should throw InvalidExpressionException
    assertThrows(InvalidExpressionException.class, () -> {
      this.cModel.evaluate(null, false);
    });
    // cModel should throw exception when there is operation without operands
    assertThrows(InvalidExpressionException.class, () -> {
      this.cModel.evaluate("+", false);
    });
    // cModel should throw exception when there is only one operand for addition
    assertThrows(InvalidExpressionException.class, () -> {
      this.cModel.evaluate("1 +", false);
    });
    // cModel should throw exception when there is invalid symbols i.e. pound sign
    assertThrows(InvalidExpressionException.class, () -> {
      this.cModel.evaluate("£", false);
    });
  }

}
