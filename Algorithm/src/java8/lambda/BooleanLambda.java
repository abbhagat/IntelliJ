package java8.lambda;

import java.util.Arrays;
import java.util.List;

public class BooleanLambda {

    private final static List<String> list;

    static {
        list = Arrays.asList("A", "B", "C", "D", "E");
    }

    static boolean isPresent(String s) {
        return list.contains(s);
    }

    static boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static void main(String... args) {
        System.out.println(isEven(2));
        System.out.println(isPresent("A"));
    }
}
