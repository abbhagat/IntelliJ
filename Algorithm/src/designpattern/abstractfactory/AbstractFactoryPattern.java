package designpattern.abstractfactory;

/* Abstract Factory patterns work around a super-factory which creates other factories.
 * In Abstract Factory pattern an interface is responsible for creating a factory of
 * related objects without explicitly specifying their classes.
 */

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Circle::draw() method.");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle::draw() method.");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Square::draw() method.");
    }
}

interface Color {
    void fill();
}

class Red implements Color {

    public void fill() {
        System.out.println("Red::fill() method.");
    }
}

class Blue implements Color {

    public void fill() {
        System.out.println("Blue::fill() method.");
    }
}

class Green implements Color {

    public void fill() {
        System.out.println("Green::fill() method.");
    }
}

abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactory {

    public Shape getShape(String shape) {
        switch (shape.toLowerCase()) {
            case "circle"   : return new Circle();
            case "square"   : return new Square();
            case "rectangle": return new Rectangle();
            default         : return null;
        }
    }

    public Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends AbstractFactory {

    Color getColor(String color) {
        switch (color.toLowerCase()) {
            case "red"  : return new Red();
            case "green": return new Green();
            case "blue" : return new Blue();
            default:      return null;
        }
    }

    public Shape getShape(String shapeType) {
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        return choice.equalsIgnoreCase("SHAPE") ? new ShapeFactory() : new ColorFactory();
    }
}

public class AbstractFactoryPattern {

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();
        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();
        Shape square = shapeFactory.getShape("square");
        square.draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color red = colorFactory.getColor("red");
        red.fill();
        Color green = colorFactory.getColor("Green");
        green.fill();
        Color blue = colorFactory.getColor("BLUE");
        blue.fill();
    }
}
