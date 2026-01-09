import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shape.*;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    context.registerShutdownHook();
    Shape shape = context.getBean("triangles", Shape.class);
    shape.draw();
    Employee emp1 = context.getBean("employee", Employee.class);
    Employee emp2 = context.getBean("employee", Employee.class);
    System.out.println("Emp1 HashCode :- " + emp1.hashCode());
    System.out.println("Emp2 HashCode :- " + emp2.hashCode());
    System.out.println("Address1 HashCode :- " + emp1.getAddress().hashCode());
    System.out.println("Address2 HashCode :- " + emp2.getAddress().hashCode());
    Address add1 = context.getBean("address", Address.class);
    Address add2 = context.getBean("address", Address.class);
    System.out.println("Address1 HashCode :- " + add1.hashCode());
    System.out.println("Address2 HashCode :- " + add2.hashCode());
    System.out.println("Bean Count " + context.getBeanDefinitionCount());
    Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    Rectangle rectangle = context.getBean("rectangle", Rectangle.class);
    Arrays.stream(rectangle.getPointArray()).forEach(point -> System.out.println(point.getX() + "," + point.getY()));
    context.close();
  }
}
