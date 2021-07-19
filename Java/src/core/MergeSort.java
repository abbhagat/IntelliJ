package core;

import java.util.stream.IntStream;

public class MergeSort {

    private static int[] a = {100, 23, 4, 19, 18, 2, 1, 36, 55, 87};
    private static int[] temp = new int[a.length];

    public static void main(String[] args) {
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
            temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
        }
        if (i > mid) {
            for (int l = i; l <= high; l++) {
                temp[k++] = a[l];
            }
        } else {
            for (int l = i; l <= mid; l++) {
                temp[k++] = a[l];
            }
        }
        for (int l = low; l <= high; l++) {
            a[l] = temp[l];
        }
    }
}
