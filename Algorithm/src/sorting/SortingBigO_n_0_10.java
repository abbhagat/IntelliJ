package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

public class SortingBigO_n_0_10 {

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 0, 1, 8, 9, 7, 10, 5, 6};
        int i = 0;
        while (i < a.length) {
            if (a[i] != i) {
                swap(a, i, a[i]);
            } else {
                i++;
            }
        }
        printArray(a);
    }
}
