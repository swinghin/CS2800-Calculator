package calculator;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Create a view and model. Adds itself as an observer to the view so that (asynchronous) changes
 * can be observed.
 * 
 * @author wjis132
 */
public final class CalcController extends Application {

  private CalcModel model = new CalcModel();
  private boolean isInfix = true;

  /**
   * Main window for {@link calculator.CalcController}.
   */
  private Pane mainPane;

  /**
   * Label for {@link calculator.CalcController#txtExpression} TextField.
   */
  private Label lblExpression;
  /**
   * TextField for user expression.
   */
  private TextField txtExpression;


  /**
   * Limits the selection of {@link calculator.CalcController#rbnRevPol} and
   * {@link calculator.CalcController#rbnInfix} to be mutually exclusive.
   */
  private ToggleGroup togIsInfix;
  /**
   * RadioButton for choosing Reverse Polish mode.
   */
  private RadioButton rbnRevPol;
  /**
   * RadioButton for choosing Infix mode.
   */
  private RadioButton rbnInfix;

  /**
   * Button that starts the calculation, onAction set to
   * {@link calculator.GuiView#addCalcObserver()}.
   */
  private Button btnCalculate;

  /**
   * Label for {@link calculator.CalcController#txtResult} TextField.
   */
  private Label lblResult;

  private TextField txtResult;


  /**
   * Is notified when a calculation is required.
   */
  public void calculate() {
    try {
      txtResult.setText(String.valueOf(model.evaluate(txtExpression.getText(), isInfix)));
    } catch (InvalidExpressionException e) {
      txtResult.setText(e.getMessage());
    }
  }

  /**
   * Is notified when a change of expression type is indicated.
   */
  public void expressionType() {
    isInfix = !isInfix;
  }

  /**
   * Start CalcContoller.
   * 
   * @param args String arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Entry point for JavaFX graphical user interface.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {

    lblExpression = new Label();
    lblExpression.setText("Expression");

    txtExpression = new TextField();
    txtExpression.setPromptText("Enter an expression...");

    togIsInfix = new ToggleGroup();

    rbnRevPol = new RadioButton();
    rbnRevPol.setToggleGroup(togIsInfix);
    rbnRevPol.setText("Reverse Polish");
    rbnRevPol.setOnAction(event -> expressionType());

    rbnInfix = new RadioButton();
    rbnInfix.setToggleGroup(togIsInfix);
    rbnInfix.setText("Infix");
    rbnInfix.setSelected(isInfix);
    rbnInfix.setOnAction(event -> expressionType());

    btnCalculate = new Button();
    btnCalculate.setText("Calculate");
    btnCalculate.setOnAction(event -> calculate());

    lblResult = new Label();
    lblResult.setText("Result");

    txtResult = new TextField();
    txtResult.setEditable(false);
    txtResult.setPromptText("Click 'Calculate' to get result...");



    mainPane = new Pane();
    mainPane.getChildren().add(new VBox(new HBox(lblExpression, txtExpression),
        new HBox(rbnRevPol, rbnInfix), new HBox(btnCalculate), new HBox(lblResult, txtResult)));

    Scene scene = new Scene(mainPane, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("CS2800 Calculator");
    primaryStage.show();
  }

}
