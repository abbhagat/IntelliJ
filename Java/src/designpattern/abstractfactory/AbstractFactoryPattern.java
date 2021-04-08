package designpattern.abstractfactory;

/* Abstract Factory patterns work around a super-factory which creates other factories.
 * In Abstract Factory pattern an interface is responsible for creating a factory of related objects
 * without explicitly specifying their classes.
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

interface Color {
    void fill();
}

class Red implements Color {

    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}

class Blue implements Color {

    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}

class Green implements Color {

    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}

abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactory {

    public Shape getShape(String shape) {
        Shape s = null;
        if (shape.equalsIgnoreCase(null)) {
            s = null;
        } else if (shape.equalsIgnoreCase("circle")) {
            s = new Circle();
        } else if (shape.equalsIgnoreCase("square")) {
            s = new Square();
        } else if (shape.equalsIgnoreCase("rectangle")) {
            s = new Rectangle();
        }
        return s;
    }

    Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends AbstractFactory {

    public Shape getShape(String shapeType) {
        return null;
    }

    Color getColor(String color) {

        if (color == null) {
            return null;
        }

        if (color.equalsIgnoreCase("RED")) {
            return new Red();

        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();

        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }

        return null;
    }
}

class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {

        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}

public class AbstractFactoryPattern {

    public static void main(String[] args) {
        // get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        // get an object of Shape Circle
        Shape circle = shapeFactory.getShape("CIRCLE");

        // call draw method of Shape Circle
        circle.draw();

        // get an object of Shape Rectangle
        Shape rectangle = shapeFactory.getShape("RECTANGLE");

        // call draw method of Shape Rectangle
        rectangle.draw();

        // get an object of Shape Square
        Shape square = shapeFactory.getShape("SQUARE");

        // call draw method of Shape Square
        square.draw();

        // get color factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        // get an object of Color Red
        Color red = colorFactory.getColor("RED");

        // call fill method of Red
        red.fill();

        // get an object of Color Green
        Color green = colorFactory.getColor("Green");

        // call fill method of Green
        green.fill();

        // get an object of Color Blue
        Color blue = colorFactory.getColor("BLUE");

        // call fill method of Color Blue
        blue.fill();
    }
}
