package searching;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class MissingNumber {

    public static void main(String[] args) {
        int[] a = {9, 7, 3, 4, 10, 1, 2, 8, 6};
        int max = a[0], min = a[0];
        int sum1 = 0, sum2 = 0;
        for (int x : a) {
            max = max(max, x);
            min = min(min, x);
            sum1 += x;
        }
        for (int i = min; i <= max; i++) {
            sum2 += i;
        }
        System.out.println("Missing Num : " + (sum2 - sum1));
    }
}
