package application;


public class CalcModel implements Calculator {

  private StandardCalc standardCalc;
  private RevPolishCalc revPolishCalc;


  public CalcModel() {
    this.standardCalc = new StandardCalc();
    this.revPolishCalc = new RevPolishCalc();
  }


  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    return infix ? standardCalc.evaluate(expression) : revPolishCalc.evaluate(expression);
  }
}
