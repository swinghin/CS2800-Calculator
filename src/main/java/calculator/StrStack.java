package calculator;

import java.util.EmptyStackException;

public class StrStack {

  public StrStack() {}

  public void push(String i) {}

  public String pop() {
    throw new EmptyStackException();
  }

  public Boolean isEmpty() {
    return true;
  }

}
