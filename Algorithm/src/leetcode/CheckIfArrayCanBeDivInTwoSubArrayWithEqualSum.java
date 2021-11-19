package leetcode;

import java.util.stream.IntStream;

public class CheckIfArrayCanBeDivInTwoSubArrayWithEqualSum {

    private static boolean check(int[] a) {
        int sum = 0, sum_so_far = 0;;
        for (int x : a) {
            sum += x;
        }
        for (int i = 0; i < a.length; i++) {
            if (sum_so_far * 2 + a[i] == sum) {
                IntStream.range(0, i).forEach(j -> System.out.print(a[j] + " "));
                System.out.println();
                IntStream.range(i + 1, a.length).forEach(j -> System.out.print(a[j] + " "));
                System.out.println();
                return true;
            }
            sum_so_far += a[i];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{6, 2, 3, 2, 1}));
    }
}
