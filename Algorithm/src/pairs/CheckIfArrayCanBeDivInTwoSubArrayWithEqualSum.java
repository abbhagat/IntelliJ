package pairs;

import java.util.Arrays;
import java.util.stream.IntStream;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class CheckIfArrayCanBeDivInTwoSubArrayWithEqualSum {

    private static int check(int[] a) {
        int sum1 = Arrays.stream(a).sum();
        int sum2 = 0;
        for (int i = 0; i < a.length; i++) {
             sum2 += a[i];
             sum1 -= a[i];
             if (sum1 == sum2) {
                 return i;
             }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] M = {{6, 2, 3, 2, 1}, {6, 6}, {6, 3, 2, 1}};
        for (int[] a : M) {
             int i = check(a);
             if (i != -1) {
                 IntStream.range(0, i + 1)       .forEach(j -> System.out.print(a[j] + " "));
                 System.out.print("and ");
                 IntStream.range(i + 1, a.length).forEach(j -> System.out.print(a[j] + " "));
                 System.out.println();
             } else {
                 System.out.println("Array cannot be divided into two sub arrays with equal sum");
             }
        }
    }
}
