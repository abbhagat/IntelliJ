package org.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* org.spring.aop.shape*..set*(..))")
    public void triangle() {
    }

    @Before("triangle())")
    public void beforeAdvice() {
        System.out.println("@Before");
    }

    @After("triangle())")
    public void afterLoggingAdvice() {
        System.out.println("@After");
    }

    @AfterReturning(pointcut = "triangle()", returning = "name")
    public void afterReturningAdvice(String name) {
        System.out.println("@AfterReturning " + name);
    }

    @AfterThrowing(pointcut = "triangle()", throwing = "ex")
    public void afterThrowingAdvice(Exception ex) {
        System.out.println("@AfterThrowing " + ex.toString());
    }

    @Around("triangle()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("@Around Before Target");
        try {
            proceedingJoinPoint.proceed();  // Executes the target method
            System.out.println("@Around AfterReturning Target");
        } catch (Throwable t) {
            System.out.println("@Around AfterThrowing Target");
        }
        System.out.println("@Around After Finally");
    }

    @Pointcut("args(org.spring.aop.service.Shape)")
    public void argsWithShapeParameter() {
    }

    @Pointcut("within(org.spring.aop.shape.Triangle)")
    public void withinTriangle() {
    }

//    @Before("argsWithShapeParameter()")
//    public void adviceForShapeArgs() {
//        System.out.println("Args with Shape param called");
//    }

    /*
        @Before("execution(* *org.spring.aop..*(..))")
        public void loggingAdviceForAllMethodsHavingZeroOrMoreArgs() {
            System.out.println("Generic Advice Called Packages and Sub Packages for methods having 0 or more args");
        }

        @Before("execution(* *org.spring.aop..*(*))")
        public void loggingAdviceForAllMethodsHavingOneOrMoreArgs() {
            System.out.println("Generic Advice Called Packages and Sub Packages for methods having 1 or more args");
        }

    */

}
