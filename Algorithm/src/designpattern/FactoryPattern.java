package designpattern;

/* In Factory Design Pattern we create objects without exposing the creation logic to the client
 * and refer to the newly created object using a common interface.
 */

interface Shape {
    void draw();
}

class Circle implements Shape {

    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

class Rectangle implements Shape {

    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {

    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class ShapeFactory {

    public Shape getShape(String shape) {
        switch (shape.toLowerCase()) {
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            case "rectangle":
                return new Rectangle();
            default:
                return null;
        }
    }
}

public class FactoryPattern {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape c = shapeFactory.getShape("CIRCLE");
        c.draw();
        Shape r = shapeFactory.getShape("RECTANGLE");
        r.draw();
        Shape s = shapeFactory.getShape("SQUARE");
        s.draw();
    }
}
