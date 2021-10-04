package searching;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class MissingNumber {

    public static void main(String[] args) {
        int[] a = {9, 7, 3, 4, 10, 1, 2, 8, 6};
        int max = a[0], min = a[0];
        int n = a.length + 1;
        int sum1 = 0, sum2;
        for (int x : a) {
            max = max(max, x);
            min = min(min, x);
            sum1 += x;
        }
        sum2 = ((min + max) * n) / 2;
        System.out.println("Missing Num : " + (sum2 - sum1));
    }
}
