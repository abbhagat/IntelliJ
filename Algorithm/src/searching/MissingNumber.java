package searching;

import java.util.Arrays;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class MissingNumber {

    public static void main(String[] args) {
        int[] a = {9, 7, 3, 4, 10, 1, 2, 8, 6};
        int max = a[0], min = a[0];
        int sum1 = Arrays.stream(a).reduce(0, Integer::sum);
        int sum2 = 0;
        for (int x : a) {
            min = min(min, x);
            max = max(max, x);
        }
        for (int i = min; i <= max; i++) {
            sum2 += i;
        }
        System.out.println("Missing Num : " + (sum2 - sum1));
    }
}
