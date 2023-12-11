package application;

/**
 * The controller in the MVC pattern for the calculator application. It handles interactions between
 * the model (CalcModel) and the view (ViewInterface).
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isUsingInfix = false; // Default mode set to false (Reverse Polish Notation)

  /**
   * Constructor for the CalcController. Sets up the controller with the specified model and view,
   * and initialises observers for user interactions.
   *
   * @param model The CalcModel instance representing the calculator's model.
   * @param view The ViewInterface instance representing the calculator's view.
   */
  public CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model;
    this.myView = view;

    // Set up observers for handling calculate and type change actions in the view.
    myView.addCalculateObserver(this::handleCalculation);
    myView.addTypeObserver(this::handleTypeChange);
  }

  /**
   * Handles the calculation process when triggered by the view. It retrieves the current expression
   * from the view, asks the model to evaluate it, and updates the view with the result.
   */
  public void handleCalculation() {
    try {
      // Get the expression from the view
      String expression = myView.getExpression();

      // Evaluate the expression using the model
      float result = myModel.evaluate(expression, isUsingInfix);

      // Update the view with the formatted result
      myView.setAnswer(String.format("%.2f", result));
    } catch (InvalidExpression e) {
      // Update the view with an error message in case of an invalid expression
      myView.setAnswer("Error: " + e.getMessage());
    }
  }

  /**
   * Handles changes in calculation type (infix or RPN) as indicated by the view.
   *
   * @param type The calculation type (STANDARD for infix, REV_POLISH for RPN).
   */
  public void handleTypeChange(OpType type) {
    // Set the calculation type based on the user's selection from the view
    this.isUsingInfix = (type == OpType.STANDARD);
  }
}
