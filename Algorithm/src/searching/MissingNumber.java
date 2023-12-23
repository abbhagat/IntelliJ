package searching;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] a = {9, 7, 3, 4, 10, 1, 2, 8, 6};
        int sum = Arrays.stream(a).sum();
        int min = Arrays.stream(a).min().getAsInt();
        int max = Arrays.stream(a).max().getAsInt();
        int sum2 = 0;
        for (int i = min; i <= max; i++) {
            sum2 += i;
        }
        System.out.println("Missing Num : " + (sum2 - sum));
    }
}
