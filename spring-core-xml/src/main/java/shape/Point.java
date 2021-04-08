package shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Point implements Shape{

    private int X;
    private int Y;

    public void draw() {
        System.out.println("Point (" + getX() + "," + getY() + ")");
    }
}
