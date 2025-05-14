package arrays;

import java.util.Arrays;

public class SortBinaryArrayInBigO_N_TimeComplexity {

    private static void sort(int[] a) {
        int countZero = 0;
        for (int x : a) {
            if (x == 0) {
                countZero++;
            }
        }
        Arrays.fill(a, 0, countZero, 0);
        Arrays.fill(a, countZero, a.length, 1);
    }
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
