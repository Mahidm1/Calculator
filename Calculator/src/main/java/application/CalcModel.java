package application;


/**
 * The CalcModel class represents the model in the MVC pattern for the calculator application. It is
 * responsible for evaluating mathematical expressions in either infix or Reverse Polish Notation
 * (RPN) form.
 */
public class CalcModel implements Calculator {

  private StandardCalc standardCalc;
  private RevPolishCalc revPolishCalc;

  /**
   * Constructor for CalcModel. It initialises the StandardCalc and RevPolishCalc instances for
   * evaluating expressions.
   */
  public CalcModel() {
    this.standardCalc = new StandardCalc();
    this.revPolishCalc = new RevPolishCalc();
  }

  /**
   * Evaluates a given mathematical expression.
   * 
   * @param expression The mathematical expression in a String format.
   * @param infix A Boolean flag to indicate if the expression is in infix notation (true) or RPN
   *        (false).
   * @return The result of the evaluated expression as a float.
   * @throws InvalidExpression If the expression is invalid or cannot be evaluated.
   */
  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    return infix ? standardCalc.evaluate(expression) : revPolishCalc.evaluate(expression);
  }
}
