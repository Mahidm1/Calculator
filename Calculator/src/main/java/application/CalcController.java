package application;

public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isUsingInfix = false;


  public CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model;
    this.myView = view;

    myView.addCalculateObserver(this::handleCalculation);
    myView.addTypeObserver(this::handleTypeChange);
  }


  public void handleCalculation() {
    try {
      String expression = myView.getExpression();
      float result = myModel.evaluate(expression, isUsingInfix);
      myView.setAnswer(String.format("%.2f", result));
    } catch (InvalidExpression e) {
      myView.setAnswer("Error: " + e.getMessage());
    }
  }


  public void handleTypeChange(OpType type) {
    this.isUsingInfix = (type == OpType.STANDARD);
  }

}
