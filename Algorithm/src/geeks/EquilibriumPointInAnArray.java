package geeks;

import java.util.Arrays;

public class EquilibriumPointInAnArray {

    private static int findEquilibriumPoint(int[] a) {
        int sum1 = Arrays.stream(a).sum();
        int sum2 = 0;
        for (int x : a) {
            sum2 += x;
            if (sum1 == sum2) {
                return x;
            }
            sum1 -= x;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findEquilibriumPoint(new int[]{1, 2, 3, 2, 1}));
        System.out.println(findEquilibriumPoint(new int[]{1, 3, 4, 2, 15, 6, 3, 1}));
        System.out.println(findEquilibriumPoint(new int[]{6, 3, 2, 1}));
    }
}
