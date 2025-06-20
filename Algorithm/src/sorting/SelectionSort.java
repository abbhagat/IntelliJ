package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity O(n^2)
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {20, 3, 15, 6, 9, 8, 2, 1, 6, 8, 7, 15};
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
        printArray(a);
    }
}
