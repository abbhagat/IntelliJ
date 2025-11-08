package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

public class SortArrayContainingOnlyZerosAndOnes {

    private static void sortBinaryArrayAscOrder(int[] a) {
        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[i] == 0) {
                swap(a, i, j);
                j++;
            }
        }
        printArray(a);
    }

    private static void sortBinaryArrayDescOrder(int[] a) {
        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[i] == 1) {
                swap(a, i, j);
                j++;
            }
        }
        printArray(a);
    }

    public static void main(String[] args) {
        sortBinaryArrayAscOrder(new int[]{0, 1, 0, 1, 0, 1, 0, 1});
        sortBinaryArrayAscOrder(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1});
        sortBinaryArrayDescOrder(new int[]{0, 1, 0, 1, 0, 1, 0, 1});
        sortBinaryArrayDescOrder(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1});
    }
}
