package calculator;

import java.util.EmptyStackException;

/**
 * Evaluates Reverse Polish String Expressions.
 * 
 * @author wjis132
 */
public class RevPolishCalc implements Calculator {

  private NumStack values;

  /**
   * Interface function for evaluating Reverse Polish string expressions.
   * 
   * @param what Reverse Polish string expressions for evaluation.
   * @return float The result of the evaluation.
   * @throws InvalidExpressionException Thrown when the string expression is invalid.
   */
  @Override
  public float evaluate(String what) throws InvalidExpressionException {

    if (what == null) {
      // If expression is null, throw InvalidExpressionException
      throw new InvalidExpressionException("Invalid Expression: Expression is null");
    } else {

      // If expression is not null, create a new NumStack
      values = new NumStack();

      // Split the incoming string expression to items with spaces
      String[] items = what.split("\\s+");

      // For each item, check the type: if number, push to stack; if operator, perform operation
      for (int i = 0; i < items.length; i++) {
        try {
          // If parseFloat is successful, it means the item is indeed a number
          float operand = Float.parseFloat(items[i]);
          // Now push it into values
          values.push(operand);
        } catch (NumberFormatException nfe) {
          try {
            // NumberFormatException means item not number, now check if it is a valid symbol (+-*/)

            // pop the top operand first
            float topValue = values.pop();

            // Now check if it is a valid symbol (+ - * /)
            switch (items[i]) {
              case "+":
                values.push(values.pop() + topValue);
                break;
              case "-":
                values.push(values.pop() - topValue);
                break;
              case "*":
                values.push(values.pop() * topValue);
                break;
              case "/":
                values.push(values.pop() / topValue);
                break;
              default:
                // if not valid symbol (+ - * /), would be invalid operator
                throw new InvalidExpressionException("Invalid Expression: Invalid operator");
            }
          } catch (EmptyStackException ese) {
            // Pop from stack throwing EmptyStackException means not enough operands for operation
            throw new InvalidExpressionException("Invalid Expression: Not enough operands");
          }
        }
      }
      return values.pop();
    }
  }

}
