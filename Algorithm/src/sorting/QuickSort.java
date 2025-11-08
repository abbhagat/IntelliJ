package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity O(n log n)
public class QuickSort {

    private static void quickSort(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int mid = (low + high) / 2;
        int key = a[mid];
        while (a[i] < key) {
            i++;
        }
        while (a[j] > key) {
            j--;
        }
        if (i <= j) {
            swap(a, i, j);
            i++;
            j--;
        }
        if (i < high) {
            quickSort(a, i, high);
        }
        if (j > low) {
            quickSort(a, low, j);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 3, 4, 6, 9, 2, 1, 5, 8, 7};
        quickSort(a, 0, a.length - 1);
        printArray(a);
    }
}
