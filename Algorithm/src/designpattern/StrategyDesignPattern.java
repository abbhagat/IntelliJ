package designpattern;

/* In this design pattern, the behavior of a class can be changed at runtime.
 * Here we create objects which represent various strategies and a context object
 * whose behavior varies as per its strategy object.
 * Comparable, Comparator and Collections.sort() is the strategy pattern in Java API.
 */

interface Strategy {
    int execute(int x, int y);
}

class Add implements Strategy {

    public int execute(int x, int y) {
        return x + y;
    }
}

class Sub implements Strategy {

    public int execute(int x, int y) {
        return x - y;
    }
}

class Mul implements Strategy {

    public int execute(int x, int y) {
        return x * y;
    }
}

class Div implements Strategy {

    public int execute(int x, int y) {
        return x / y;
    }
}

class Context {

    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.execute(num1, num2);
    }
}

public class StrategyDesignPattern {

    public static void main(String[] args) {
        System.out.println(new Context(new Add()).executeStrategy(10, 5));
        System.out.println(new Context(new Sub()).executeStrategy(10, 5));
        System.out.println(new Context(new Mul()).executeStrategy(10, 5));
        System.out.println(new Context(new Div()).executeStrategy(10, 5));
    }
}
