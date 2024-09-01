package shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
