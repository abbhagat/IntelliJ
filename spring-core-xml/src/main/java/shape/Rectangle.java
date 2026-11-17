package shape;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Rectangle {

  private Point[] pointArray;

  public Point[] getPointArray() {
    return pointArray;
  }

  public void setPointArray(Point[] pointArray) {
    this.pointArray = pointArray;
  }
}
