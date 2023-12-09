package application;

import java.util.Stack;

/**
 * This class provides functionality to evaluate expressions written in standard (infix) notation.
 */
public class StandardCalc {
  private OpStack values;
  private RevPolishCalc rpCalc;
  private Stack<Character> operator = new Stack<>();
  private Stack<String> reversePolish = new Stack<>();

  /**
   * Constructs a StandardCalc with a given OpStack and RevPolishCalc.
   */
  public StandardCalc() {
    this.values = new OpStack();
    this.rpCalc = new RevPolishCalc();
  }

  /**
   * Evaluates a standard (infix) notation expression by first converting it to Reverse Polish
   * Notation.
   * 
   * @param exp The expression to evaluate.
   * @return The result of the evaluated expression.
   * @throws InvalidExpression If the expression is invalid or malformed.
   */
  public float evaluate(String exp) throws InvalidExpression {
    String rpn = convertToReversePolish(exp); // Perform conversion within this method.
    return rpCalc.evaluate(rpn); // Use RevPolishCalc to evaluate the RPN expression.
  }

  /**
   * Converts an infix expression to Reverse Polish Notation. This method is private to encapsulate
   * the conversion logic within the StandardCalc class.
   * 
   * @param exp The infix expression to convert.
   * @return The converted RPN expression.
   * @throws InvalidExpression If the conversion cannot be performed.
   */
  private String convertToReversePolish(String exp) throws InvalidExpression {
    // Initial conversion setup
    StringBuilder output = new StringBuilder();
    for (char c : exp.toCharArray()) {
      if (Character.isDigit(c) || c == '.') {
        output.append(c);
      } else if (c == '(') {
        operator.push(c);
      } else if (c == ')') {
        while (!operator.isEmpty() && operator.peek() != '(') {
          output.append(' ').append(operator.pop());
        }
        if (!operator.isEmpty() && operator.peek() != '(')
          throw new InvalidExpression("Invalid Expression");
        else
          operator.pop();
      } else if (isOperator(c)) {
        while (!operator.isEmpty() && precedence(c) <= precedence(operator.peek())) {
          if (operator.peek() == '(')
            throw new InvalidExpression("Invalid Expression");
          output.append(' ').append(operator.pop());
        }
        output.append(' ');
        operator.push(c);
      }
    }

    while (!operator.isEmpty()) {
      output.append(' ').append(operator.pop());
    }

    return output.toString().trim();
  }

  /**
   * Helper method to check if a character is an operator.
   * 
   * @param c The character to check.
   * @return true if the character is an operator, false otherwise.
   */
  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/');
  }

  /**
   * Helper method to determine the precedence of operators.
   * 
   * @param c The operator to check.
   * @return An integer value representing the precedence of the operator.
   */
  private int precedence(char c) {
    switch (c) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
    }
    return -1;
  }
}
