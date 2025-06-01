package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity O(n^2)
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {20, 3, 15, 6, 9, 8, 2, 1, 6, 8, 7, 15};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        printArray(a);
    }
}
