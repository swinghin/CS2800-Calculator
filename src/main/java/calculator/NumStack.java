package calculator;

import java.util.EmptyStackException;

public class NumStack{
  public NumStack() {
    super();
  }

  public void push(float i) {

  }

  public float pop() {
    throw new EmptyStackException();
  }

  public Boolean isEmpty() {
    return true;
  }
}
