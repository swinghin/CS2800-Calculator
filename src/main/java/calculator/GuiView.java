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

  @FXML
  private Pane mainPane;

  @FXML
  private Label lblExpression;
  @FXML
  private TextField txtExpression;


  @FXML
  private ToggleGroup togIsInfix;
  @FXML
  private RadioButton rbnRevPol;
  @FXML
  private RadioButton rbnInfix;

  @FXML
  private Button btnCalculate;

  @FXML
  private Label lblResult;
  @FXML
  private TextField txtResult;

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

  @Override
  public String getExpression() {
    expression = txtExpression.getText();
    return expression;
  }

  @Override
  public void setAnswer(String str) {
    answer = str;
    txtResult.setText(answer);
  }

  @FXML
  @Override
  public void addCalcObserver() {
    CalcController.calculate();
  }

  @FXML
  @Override
  public void addTypeObserver() {
    CalcController.expressionType();
  }

}
