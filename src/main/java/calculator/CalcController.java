package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Create a view and model. Adds itself as an observer to the view so that (asynchronous) changes
 * can be observed.
 * 
 * @author wjis132
 */
public final class CalcController extends Application {

  private static CalcModel model = new CalcModel();
  private static ViewInterface view;
  private static boolean isInfix = true;

  /**
   * Is notified when a calculation is required.
   */
  public static void calculate() {
    try {
      view.setAnswer(String.valueOf(model.evaluate(view.getExpression(), isInfix)));
    } catch (InvalidExpressionException e) {
      view.setAnswer(e.getMessage());
    }
  }

  /**
   * Is notified when a change of expression type is indicated.
   */
  public static void expressionType() {
    isInfix = !isInfix;
  }

  /**
   * Entry point for command line interface.
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
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GuiView.fxml"));
    Pane pane = loader.load();
    view = loader.getController();
    Scene scene = new Scene(pane, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("CS2800 Calculator");
    primaryStage.show();
  }

}
