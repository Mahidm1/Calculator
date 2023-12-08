package application;

import java.util.Stack;

public class StandardCalc {
  private OpStack values;
  private RevPolishCalc rpCalc;
  private Stack<Character> operator = new Stack<>();
  private Stack<String> reversePolish = new Stack<>();

  public StandardCalc() {
    this.values = new OpStack();
    this.rpCalc = new RevPolishCalc();
  }

  public float convertToReversePolish(String exp) throws InvalidExpression {
    if (exp.isEmpty()) {
      throw new InvalidExpression("Expression is empty");
    }

    String res = "";
    int len = exp.length();
    operator.push('#');

    for (int i = 0; i < len;) {
      while (i < len && exp.charAt(i) == ' ') {
        i++;
      }
      if (i == len) {
        break;
      }

      if (isNum(exp.charAt(i))) {
        String num = "";
        while (i < len && isNum(exp.charAt(i))) {
          num += exp.charAt(i++);
        }
        reversePolish.push(num);
      } else {
        char op = exp.charAt(i);
        switch (op) {
          case '(':
          case ')':
          case '+':
          case '-':
          case '*':
          case '/':
            handleOperator(op);
            break;
          default:
            throw new InvalidExpression("Invalid character: " + op);
        }
        i++;
      }
    }

    while (operator.peek() != '#') {
      reversePolish.push(Character.toString(operator.pop()));
    }
    while (!reversePolish.isEmpty()) {
      res = res.length() == 0 ? reversePolish.pop() + res : reversePolish.pop() + " " + res;
    }

    return rpCalc.evaluate(res);
  }

  private void handleOperator(char op) {
    switch (op) {
      case '(':
        operator.push(op);
        break;
      case ')':
        while (operator.peek() != '(') {
          reversePolish.push(Character.toString(operator.pop()));
        }
        operator.pop();
        break;
      case '+':
      case '-':
        if (operator.peek() == '(') {
          operator.push(op);
        } else {
          while (operator.peek() != '#' && operator.peek() != '(') {
            reversePolish.push(Character.toString(operator.pop()));
          }
          operator.push(op);
        }
        break;
      case '*':
      case '/':
        if (operator.peek() == '(') {
          operator.push(op);
        } else {
          while (operator.peek() != '#' && operator.peek() != '+' && operator.peek() != '-'
              && operator.peek() != '(') {
            reversePolish.push(Character.toString(operator.pop()));
          }
          operator.push(op);
        }
        break;
    }
  }

  public boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
  }

  public boolean isNum(char c) {
    return c >= '0' && c <= '9';
  }
}
