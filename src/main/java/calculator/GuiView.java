package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

/**
 * A graphical window with a text field for an expression, a "calculate" button, and a radio button
 * "Reverse Polish/Infix".
 * 
 * @author wjis132
 */
public class GuiView implements ViewInterface {

  private String expression;
  private String answer;

  /**
   * Main window for {@link calculator.GuiView}.
   */
  @FXML
  private Pane mainPane;

  /**
   * Label for {@link calculator.GuiView#txtExpression} TextField.
   */
  @FXML
  private Label lblExpression;
  /**
   * TextField for user expression.
   */
  @FXML
  private TextField txtExpression;


  /**
   * Limits the selection of {@link calculator.GuiView#rbnRevPol} and
   * {@link calculator.GuiView#rbnInfix} to be mutually exclusive.
   */
  @FXML
  private ToggleGroup togIsInfix;
  /**
   * RadioButton for choosing Reverse Polish mode.
   */
  @FXML
  private RadioButton rbnRevPol;
  /**
   * RadioButton for choosing Infix mode.
   */
  @FXML
  private RadioButton rbnInfix;

  /**
   * Button that starts the calculation, onAction set to
   * {@link calculator.GuiView#addCalcObserver()}.
   */
  @FXML
  private Button btnCalculate;

  @FXML
  private Label lblResult;
  @FXML
  private TextField txtResult;

  /**
   * Sets localised text to JavaFX controls in {@link calculator.GuiView}.
   */
  @FXML
  protected void initialize() {
    lblExpression.setText("Expression");
    txtExpression.setPromptText("Enter an expression...");
    rbnRevPol.setText("Reverse Polish");
    rbnInfix.setText("Infix");
    btnCalculate.setText("Calculate");
    lblResult.setText("Result");
    txtResult.setPromptText("Click 'Calculate' to get result...");
  }

  /**
   * Returns the string expression from user input in txtExpression TextField.
   */
  @Override
  public String getExpression() {
    expression = txtExpression.getText();
    return expression;
  }

  /**
   * Sets the calculated answer from str and display it to txtResult TextField.
   */
  @Override
  public void setAnswer(String str) {
    answer = str;
    txtResult.setText(answer);
  }

  /**
   * Is run when the user clicks the calculate button.
   */
  @FXML
  @Override
  public void addCalcObserver() {
    CalcController.calculate();
  }

  /**
   * Is run when the radioButton selection changes.
   */
  @FXML
  @Override
  public void addTypeObserver() {
    CalcController.expressionType();
  }

}
