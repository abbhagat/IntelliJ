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
        shapeMap.put("1", new Circles());
        shapeMap.put("2", new Squares());
        shapeMap.put("3", new Rectangles());
    }
}

public class PrototypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {

        ShapeCache.loadCache();
        Shapes shapes;
        shapes = ShapeCache.getShape("1");
        System.out.println("Shapes : " + shapes.getType());

        shapes = ShapeCache.getShape("2");
        System.out.println("Shapes : " + shapes.getType());

        shapes = ShapeCache.getShape("3");
        System.out.println("Shapes : " + shapes.getType());
    }
}
