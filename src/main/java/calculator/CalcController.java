package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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
  /**
   * TextField for answers.
   */
  private TextField txtResult;

  /**
   * Insets preset with 12px padding
   */
  private final Insets thickInset = new Insets(12f);

  /**
   * Insets preset with 6px padding
   */
  private final Insets thinInset = new Insets(6f);


  /**
   * Is notified when a calculation is required.
   */
  public void calculate() {
    try {
      // If expression is not invalid, put answer to Result TextField
      txtResult.setText(String.valueOf(model.evaluate(txtExpression.getText(), isInfix)));
    } catch (InvalidExpressionException e) {
      // If expression invalid, print the exception message to Result TextField
      txtResult.setText(e.getMessage());
    }
  }

  /**
   * Is notified when a change of expression type is indicated.
   */
  public void expressionType() {
    isInfix = !isInfix; // flips isInfix when selected toggle changes
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

    // Configure Expression Label
    lblExpression = new Label();
    lblExpression.setPadding(thinInset);
    lblExpression.setPrefWidth(100f);
    lblExpression.setAlignment(Pos.CENTER_RIGHT);
    lblExpression.setText("Expression:");

    // Configure Expression TextField
    txtExpression = new TextField();
    txtExpression.setPadding(thinInset);
    txtExpression.setPromptText("Enter an expression...");
    HBox.setHgrow(txtExpression, Priority.ALWAYS);

    // ToggleGroup for rbnRevPol and rbnInfix
    togIsInfix = new ToggleGroup();

    // Configure Reverse Polish RadioButton
    rbnRevPol = new RadioButton();
    rbnRevPol.setPadding(thinInset);
    rbnRevPol.setToggleGroup(togIsInfix);
    rbnRevPol.setText("Reverse Polish");
    rbnRevPol.setOnAction(event -> expressionType());

    // Configure Infix RadioButton
    rbnInfix = new RadioButton();
    rbnInfix.setPadding(thinInset);
    rbnInfix.setToggleGroup(togIsInfix);
    rbnInfix.setText("Infix");
    rbnInfix.setSelected(isInfix);
    rbnInfix.setOnAction(event -> expressionType());

    // Configure Calculate Button
    btnCalculate = new Button();
    btnCalculate.setPadding(thinInset);
    btnCalculate.setText("Calculate");
    // call calculate() when button is pressed
    btnCalculate.setOnAction(event -> calculate());

    // Configure Result Label
    lblResult = new Label();
    lblResult.setPadding(thinInset);
    lblResult.setPrefWidth(100f);
    lblResult.setAlignment(Pos.CENTER_RIGHT);
    lblResult.setText("Result:");

    // Configure Result TextField
    txtResult = new TextField();
    txtResult.setPadding(thinInset);
    txtResult.setEditable(false); // Not allow user to edit this field
    txtResult.setPromptText("Click 'Calculate' to get result...");
    HBox.setHgrow(txtResult, Priority.ALWAYS);

    HBox hbxExpression = new HBox(lblExpression, txtExpression);
    hbxExpression.setPadding(thickInset);
    hbxExpression.setAlignment(Pos.CENTER);

    HBox hbxRadio = new HBox(rbnRevPol, rbnInfix);
    hbxRadio.setPadding(thickInset);
    hbxRadio.setAlignment(Pos.CENTER);

    HBox hbxButton = new HBox(btnCalculate);
    hbxButton.setPadding(thickInset);
    hbxButton.setAlignment(Pos.CENTER);

    HBox hbxResult = new HBox(lblResult, txtResult);
    hbxResult.setPadding(thickInset);
    hbxResult.setAlignment(Pos.CENTER);

    VBox mainVBox = new VBox(hbxExpression, hbxRadio, hbxButton, hbxResult);
    mainVBox.setPrefWidth(600f);
    mainVBox.setPrefHeight(400f);
    mainPane = new Pane(mainVBox);

    Scene scene = new Scene(mainPane, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("CS2800 Calculator");
    primaryStage.show();
  }

}
