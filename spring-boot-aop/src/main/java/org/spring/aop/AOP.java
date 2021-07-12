package org.spring.aop;

import org.spring.aop.service.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AOP implements CommandLineRunner {

    @Autowired
    private AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(AOP.class, args);
    }

    @Override
    public void run(String... args) {
        Shape shape = context.getBean("shape", Shape.class);
        shape.getTriangle().setName("Equilateral");
        shape.getTriangle().setNameAndReturn("Equilateral");
        try {
            shape.getTriangle().setNameAndThrowException("Equilateral");
        } catch (Exception e) {
            System.out.println("Exception Caught");
        }
    }
}
