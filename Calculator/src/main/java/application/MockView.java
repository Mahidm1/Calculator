package application;

import java.util.function.Consumer;

/**
 * A mock implementation of the ViewInterface for testing purposes. This class simulates the
 * behaviour of a user interface without the need for an actual GUI.
 */
public class MockView implements ViewInterface {
  // Fields to store the expression and the answer.
  public String expression;
  public String answer;

  // A consumer to handle type change events.
  public Consumer<OpType> typeChange;

  /**
   * Adds a calculation observer. This method would typically be used to set up a listener for
   * calculation requests. In this mock implementation, it's left empty as actual calculation
   * triggering is not needed.
   *
   * @param f The Runnable to be executed for calculation.
   */
  @Override
  public void addCalculateObserver(Runnable f) {}

  /**
   * Adds a type observer to handle changes in calculation types (e.g., infix, reverse polish).
   * Stores the provided Consumer to be used in setType method.
   *
   * @param c The Consumer accepting OpType to handle type changes.
   */
  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    this.typeChange = c;
  }

  /**
   * Returns the current expression. This method simulates getting an expression from a user input
   * field in a GUI.
   *
   * @return The current expression.
   */
  @Override
  public String getExpression() {
    return this.expression;
  }

  /**
   * Sets the answer. This method simulates displaying the answer in a GUI.
   *
   * @param a The answer to be displayed.
   */
  @Override
  public void setAnswer(String a) {
    this.answer = a;
  }

  /**
   * Sets the calculation type and triggers the type change event. This method simulates a user
   * changing the type of calculation in a GUI.
   *
   * @param type The OpType to set and trigger.
   */
  public void setType(OpType type) {
    if (this.typeChange != null) {
      this.typeChange.accept(type);
    }
  }

  /**
   * Starts the view. This method would typically initialise and display the GUI. In this mock
   * implementation, it's left empty.
   */
  @Override
  public void startView() {}
}
