package leetcodes;

import java.util.Arrays;
import java.util.stream.IntStream;

import static util.CommonUtils.printArray;

public class SortABinaryArrayInO_N_Complexity {

    private static void sortBinaryArray(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[j] = 0;
                j++;
            }
        }
        IntStream.range(j, a.length).forEach(i -> a[i] = 1);
        printArray(a);
    }

    public static void main(String[] args) {
        sortBinaryArray(new int[]{0, 1, 0, 1, 0, 1, 0, 1});
        sortBinaryArray(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1});
    }
}
