package application;

public class OpStack {
  private Stack opStack;

  public OpStack() {
      opStack = new Stack();
  }

  public int size() {
      // Return 0 to indicate the stack is empty
      return 0;
  }
  
}
