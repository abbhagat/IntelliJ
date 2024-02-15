package geeks;

/*
 * Find a point in an array where sum of left side array members(wrt to that point)
 * and right side(wrt to that point) are equal..in other words equilibrium point
 * int a[] ={1,3,4,10,18,3,1,6,3,1,4}; // 18 is the point..
 */

import java.util.Arrays;

public class    EquilibriumPointInAnArray {

    private static int findEquilibriumPoint(int[] a) {
        int sum1 = Arrays.stream(a).reduce(0, Integer::sum);
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
