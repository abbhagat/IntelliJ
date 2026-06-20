package designpattern;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
abstract class Shapes implements Cloneable {

  protected String type;

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

}

class Rectangles extends Shapes {

  public Rectangles() {
    type = "Rectangles";
  }

}

class Squares extends Shapes {

  public Squares() {
    type = "Squares";
  }

}

class Circles extends Shapes {

  public Circles() {
    type = "Circles";
  }

}

class ShapeCache {

  private static final Map<String, Shapes> shapeMap = new HashMap<>();

  public static Shapes getShape(String shapeId) throws CloneNotSupportedException {
    Shapes cachedShape = shapeMap.get(shapeId);
    return (Shapes) cachedShape.clone();
  }

  public static void loadCache() {
    shapeMap.put("circle", new Circles());
    shapeMap.put("square", new Squares());
    shapeMap.put("rectangle", new Rectangles());
  }
}

public class PrototypePattern {

  public static void main(String[] args) throws CloneNotSupportedException {

    ShapeCache.loadCache();
    Shapes shapes;
    shapes = ShapeCache.getShape("circle");
    System.out.println("Shapes : " + shapes.getType());

    shapes = ShapeCache.getShape("square");
    System.out.println("Shapes : " + shapes.getType());

    shapes = ShapeCache.getShape("rectangle");
    System.out.println("Shapes : " + shapes.getType());
  }
}
