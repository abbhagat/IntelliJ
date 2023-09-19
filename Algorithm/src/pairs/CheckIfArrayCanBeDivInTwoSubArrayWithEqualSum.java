package pairs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CheckIfArrayCanBeDivInTwoSubArrayWithEqualSum {

    private static boolean check(int[] a) {
        int sum1 = Arrays.stream(a).reduce(0, Integer::sum);
        int sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            sum2 += a[i];
            if (sum1 == sum2) {
                IntStream.range(0, i).forEach(j -> System.out.print(a[j] + " and "));
                IntStream.range(i + 1, a.length).forEach(j -> System.out.print(a[j] + " "));
                System.out.println();
                return true;
            }
            sum1 -= a[i];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{6, 2, 3, 2, 1}));
        System.out.println(check(new int[]{6, 3, 2, 1}));
    }
}
