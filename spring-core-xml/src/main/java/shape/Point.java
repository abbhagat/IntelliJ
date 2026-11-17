package shape;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Point implements Shape {

  private int X;
  private int Y;

  public int getX() {
    return X;
  }

  public void setX(int x) {
    X = x;
  }

  public int getY() {
    return Y;
  }

  public void setY(int y) {
    Y = y;
  }

  public void draw() {
    System.out.println("Point (" + getX() + "," + getY() + ")");
  }
}
