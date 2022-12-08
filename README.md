# CS2800 Calculator

## Summary

This program allows the user get the answer of an expression in either reverse polish notation or infix notation using a JavaFX user interface when launched in a GUI environment or a text-based user interface when launched from a console.

## How to run

1. Download 100967435_calculator.jar from Release-1.1.
2. To run in GUI mode, double click in a graphical file explorer.
3. To run in text user interface mode, launch in console with `java -jar ./100967435_calculator.jar`.

## Using the Calculator

GUI mode:
1. Enter your expression to the top text field labeled "Expression:" (for example: `1 2 +`).
2. Choose "Reverse Polish" or "Infix" notation (default is Infix notation).
3. Click "Calculate" button.
4. The answer will appear in the bottom text field labeled "Result".
5. If the expression is invalid, an error will be shown in the result text field.

Text-based user interface:
1. When the program prompts for an expression, enter your expression as a line (for example: `1 2 +`) and press enter.
2. When the program asks you to choose Reverse Polish or Infix notation, enter `0` for reverse polish notation and `1` for infix notation and press enter.
3. The calculated answer will be shown in the console. An error will be shown if the expression is invalid.

## Build Instructions

Assuming an Ubuntu Linux build environment:
1. Clone the `release` branch of the repo to eclipse or IDE of your choice
2. Run with Maven using `compile javafx:run`.

## Author

Wing Hin Shih<br>
100967435<br>
@wjis132<br>
wing.shih.2020@live.rhul.ac.uk
