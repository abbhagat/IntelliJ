package geeks;

public class UglyNumber {

    private static boolean isUgly(int n) {
        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);
        return n == 1;
    }

    private static int maxDivide(int n, int x) {
        while (n % x == 0) {
            n /= x;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 8, 14};
        for (int x : a) {
            System.out.println(x + "\t" + (isUgly(x) ? "Ugly" : "Not Ugly"));
        }
    }
}
