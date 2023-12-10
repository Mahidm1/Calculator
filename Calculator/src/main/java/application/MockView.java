package application;

import java.util.function.Consumer;

public class MockView implements ViewInterface {
  public String expression;
  public String answer;
  public Consumer<OpType> typeChange;

  @Override
  public void addCalculateObserver(Runnable f) {}

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    this.typeChange = c;
  }

  @Override
  public String getExpression() {
    return this.expression;
  }

  @Override
  public void setAnswer(String a) {
    this.answer = a;
  }

  public void setType(OpType type) {
    if (this.typeChange != null) {
      this.typeChange.accept(type);
    }
  }

  @Override
  public void startView() {

  }
}
