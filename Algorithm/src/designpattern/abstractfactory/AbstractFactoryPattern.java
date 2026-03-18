package designpattern.abstractfactory;

/**
 * Abstract Factory patterns work around a super-factory which creates other factories.
 * In Abstract Factory pattern, an interface is responsible for creating a factory of
 * related objects without explicitly specifying their classes.
 */

interface Shape {
  void draw();
}

interface Color {
  void fill();
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
    return switch (shape.toLowerCase()) {
      case "circle" -> new Circle();
      case "square" -> new Square();
      case "rectangle" -> new Rectangle();
      default -> null;
    };
  }

  public Color getColor(String color) {
    return null;
  }
}

class ColorFactory extends AbstractFactory {

  Color getColor(String color) {
    return switch (color.toLowerCase()) {
      case "red" -> new Red();
      case "green" -> new Green();
      case "blue" -> new Blue();
      default -> null;
    };
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
    Shape shape;
    shape = shapeFactory.getShape("circle");
    System.out.println(shape instanceof Circle);
    shape.draw();
    shape = shapeFactory.getShape("rectangle");
    System.out.println(shape instanceof Rectangle);
    shape.draw();
    shape = shapeFactory.getShape("square");
    System.out.println(shape instanceof Square);
    shape.draw();

    AbstractFactory colorFactory = FactoryProducer.getFactory("color");
    Color color;
    color = colorFactory.getColor("red");
    System.out.println(color instanceof Red);
    color.fill();
    color = colorFactory.getColor("Green");
    System.out.println(color instanceof Green);
    color.fill();
    color = colorFactory.getColor("BLUE");
    System.out.println(color instanceof Blue);
    color.fill();
  }
}
