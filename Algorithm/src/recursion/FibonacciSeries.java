package recursion;

public class FibonacciSeries {

    private static void printFibonacci(int f, int s, int n) {
        if (n != 0) {
            int t = f + s;
            System.out.println(t);
            printFibonacci(s, t, --n);
        }
    }

    public static void main(String[] args) {
        int f = 0, s = 1;
        System.out.println(f);
        System.out.println(s);
        printFibonacci(f, s, 8);
    }
}
