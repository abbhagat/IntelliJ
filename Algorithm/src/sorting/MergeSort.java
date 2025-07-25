package sorting;

import static util.CommonUtils.printArray;

// Time  Complexity O(n log n)
// Space Complexity O(n)
public class MergeSort {

    private static final int[] a = {4, 5, 1, 3, 2, 9, 7, 6, 8, 10};
    private static final int[] temp = new int[a.length];

    private static void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private static void merge(int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];  // a[i] >= a[j] Descending order
        }
        while(i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        for (int l = low; l <= high; l++) {
              a[l] = temp[l];
        }
    }

    public static void main(String[] args) {
        mergeSort(0, a.length - 1);
        printArray(a);
    }
}
