package recursion;

public class FibonacciSeries {

    private static void printFibonacci(int f, int s, int n) {
        if (n != 0) {
            System.out.print(f + s + " ");
            printFibonacci(s, (f + s), --n);
        }
    }

    public static void main(String[] args) {
        int f = 0, s = 1;
        System.out.print(f + " " + s + " ");
        printFibonacci(f, s, 9);
    }
}
