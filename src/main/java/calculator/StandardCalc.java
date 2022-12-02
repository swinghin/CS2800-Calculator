package calculator;

import java.util.EmptyStackException;

/**
 * Evaluates Reverse infix String Expressions.
 * 
 * @author wjis132
 */
public class StandardCalc implements Calculator {

  private OpStack values;

  private RevPolishCalc rpCalc;

  /**
   * Constructor for {@link calculator.StandardCalc} that intialises
   * {@link calculator.RevPolishCalc#values} as {@link calculator.NumStack}.
   */
  public StandardCalc() {}

  /**
   * Interface function for evaluating standard infix string expressions.
   * 
   * @param what Standard infix string expressions for evaluation.
   * @return float The result of the evaluation.
   * @throws InvalidExpressionException Thrown when the string expression is invalid.
   */
  @Override
  public float evaluate(String what) throws InvalidExpressionException {

    if (what == null) {
      // If expression is null, throw InvalidExpressionException
      throw new InvalidExpressionException("Invalid Expression: Expression is null");
    } else {

      // If expression is not null, create a new OpStack
      values = new OpStack();
      String revPolishExp = "";

      // Split the incoming string expression to items with spaces
      String[] items = what.split("\\s+");

      // For each item, check the type: if number, push to stack; if operator, perform operation
      for (int i = 0; i < items.length; i++) {
        try {
          // If parseFloat is successful, it means the item is indeed a number
          float operand = Float.parseFloat(items[i]);

          // Now push it into values
          revPolishExp += String.valueOf(operand) + " ";
        } catch (NumberFormatException nfe) {
          try {
            // NumberFormatException means item not number, now check if it is a valid symbol +-*/()

            boolean currentPushed = false; // keeps track if current item is pushed somewhere
            Symbol currentSymbol = null; // To store current item type

            switch (items[i]) {
              case "+":
                currentSymbol = Symbol.PLUS;
                break;
              case "-":
                currentSymbol = Symbol.MINUS;
                break;
              case "*":
                currentSymbol = Symbol.TIMES;
                break;
              case "/":
                currentSymbol = Symbol.DIVIDE;
                break;
              case "(":
                values.push(Symbol.LEFT_BRACKET);
                currentPushed = true;
                break;
              case ")":
                currentSymbol = Symbol.RIGHT_BRACKET;

                while (!currentPushed) {
                  Symbol lastSymbol = values.pop();
                  if (lastSymbol != Symbol.LEFT_BRACKET) {
                    revPolishExp += lastSymbol + " ";
                  } else {
                    currentPushed = true;
                  }
                }
                break;
              default:
                // if not valid symbol +-*/(), would be invalid operator
                throw new InvalidExpressionException("Invalid Expression: Invalid operator");
            }

            // While current item is not pushed, try to push it to OpStack or RevPolishExp
            while (!currentPushed) {

              if (values.isEmpty()) {
                // If OpStack is empty, just push current item directly
                values.push(currentSymbol);
                currentPushed = true; // Stop the while loop
              } else {
                // If OpStack is not empty, find right place to push

                Symbol lastSymbol = values.pop(); // Get the top symbol

                if (lastSymbol != Symbol.LEFT_BRACKET
                    && lastSymbol.ordinal() / 2 <= currentSymbol.ordinal() / 2) {
                  // If last symbol is not ( and has greater precedence,
                  // push it to output
                  revPolishExp += lastSymbol.toString() + " ";
                } else {
                  values.push(lastSymbol); // put back last symbol
                  values.push(currentSymbol); // put current symbol above last
                  currentPushed = true; // Stop the while loop
                }
              }
            }

          } catch (EmptyStackException ese) {
            // Pop from stack throwing EmptyStackException means not enough operands for operation
            throw new InvalidExpressionException("Invalid Expression: Not enough operands");
          }
        }
      }
      while (!values.isEmpty()) {
        revPolishExp += values.pop().toString() + " ";
      }
      rpCalc = new RevPolishCalc();
      return rpCalc.evaluate(revPolishExp.trim());
    }
  }

}
