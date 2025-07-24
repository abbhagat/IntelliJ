package recursion;

import static util.CommonUtils.print;

public class FibonacciSeries {

    private static void printFibonacci(int f, int s, int n) {
        if (n != 0) {
            int t = f + s;
            print(t);
            printFibonacci(s, t, --n);
        }
    }

    public static void main(String[] args) {
        int f = 0, s = 1;
        print(f);
        print(s);
        printFibonacci(f, s, 8);
    }
}
