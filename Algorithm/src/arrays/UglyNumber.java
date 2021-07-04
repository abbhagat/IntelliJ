package arrays;

public class UglyNumber {

    private static boolean isUgly(int n) {
        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);
        return n == 1 ? true : false;
    }

    private static int maxDivide(int a, int b) {
        while (a % b == 0) {
            a /= b;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 8, 14};
        for (int x : a) {
            System.out.println(isUgly(x) ? x + "Ugly" : x + "Not Ugly");
        }
    }
}
