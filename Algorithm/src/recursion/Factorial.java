package recursion;

public class Factorial {

    private static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    private static int factorialIterative(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(factorial(3) + "\t" + factorialIterative(3));
        System.out.println(factorial(5) + "\t" + factorialIterative(5));
    }
}
