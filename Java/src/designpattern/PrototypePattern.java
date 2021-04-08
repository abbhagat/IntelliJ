package designpattern;

import java.util.HashMap;

abstract class Shapes implements Cloneable {

    protected String type;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getType() {
        return type;
    }
}

class Rectangles extends Shapes {
    public Rectangles() {
        type = "Rectangles";
    }

    public void draw() {
        System.out.println("Inside Rectangles::draw() method.");
    }
}

class Squares extends Shapes {

    public Squares() {
        type = "Squares";
    }

    public void draw() {
        System.out.println("Inside Squares::draw() method.");
    }
}

class Circles extends Shapes {

    public Circles() {
        type = "Circles";
    }

    public void draw() {
        System.out.println("Inside Circles::draw() method.");
    }
}

class ShapeCache {

    private static HashMap<String, Shapes> shapeMap = new HashMap<>();

    static {
        shapeMap.put("1", new Circles());
        shapeMap.put("2", new Squares());
        shapeMap.put("3", new Rectangles());
    }

    public static Shapes getShape(String shapeId)throws CloneNotSupportedException {
        Shapes cachedShape = shapeMap.get(shapeId);
        return (Shapes)cachedShape.clone();
    }

}

public class PrototypePattern {
    public static void main(String[] args)throws CloneNotSupportedException {

        Shapes shape = ShapeCache.getShape("1");
        System.out.println("Shapes : " + shape.getType());
        if(shape instanceof Circles){
            ((Circles) shape).draw();
        }
        shape = ShapeCache.getShape("2");
        System.out.println("Shapes : " + shape.getType());
        if(shape instanceof Squares){
            ((Squares) shape).draw();
        }
        shape = ShapeCache.getShape("3");
        System.out.println("Shapes : " + shape.getType());
        if(shape instanceof Rectangles){
            ((Rectangles) shape).draw();
        }
    }
}
