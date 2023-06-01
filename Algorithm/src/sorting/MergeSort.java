package sorting;

import java.util.stream.IntStream;

public class MergeSort {

    private static final int[] a = {4, 5, 1, 3, 2, 7, 6, 8};
    private static final int[] temp = new int[a.length];

    public static void main(String[] args) {
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
        mergeSort(0, a.length - 1);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }

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
            temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
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
}
