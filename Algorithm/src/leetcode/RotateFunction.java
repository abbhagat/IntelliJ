package leetcode;

import static java.lang.Integer.max;

public class RotateFunction {

    private static int rotate(int[] a) {
        int sum = 0, k = 0, n = a.length;
        for (int i = 0; i < n; i++) {
            k += i * a[i];
            sum += a[i];
        }
        int max = k;
        for (int i = n - 1; i >= 1; i--) {
            k += sum - n * a[i];
            max = max(max, k);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(rotate(new int[]{4, 3, 2, 6}));
    }
}
