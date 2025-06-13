package arrays;

import java.util.Arrays;

import static util.CommonUtils.swap;

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
        System.out.println(Arrays.toString(a));
    }

    private static void sortArray(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                swap(a, i, j);
                j++;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        sort(new int[] {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1});
        sortArray(new int[] {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1});
    }
}
