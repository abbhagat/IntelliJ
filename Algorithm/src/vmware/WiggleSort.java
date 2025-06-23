package vmware;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

public class WiggleSort {

    private static void wiggleSort(int[] a) {
        for (int i = 1; i + 1 < a.length; i++) {
            if ((i % 2 == 0) == (a[i] > a[i + 1])) {
                swap(a, i, i + 1);
            }
        }
        printArray(a);
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }
}
