package calculator;

import java.util.EmptyStackException;

public class OpStack {

  public OpStack() {}

  public void push(Symbol i) {}

  public Symbol pop() {
    throw new EmptyStackException();
  }

  public Boolean isEmpty() {
    return true;
  }

}
