package sorting;

import java.util.stream.IntStream;

public class MergeSort {

    private static int[] a = {20, 3, 15, 6, 9, 8, 2, 1, 6, 8, 7, 15, 20, 19};
    private static int temp[] = new int[a.length];

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
        int i = low;
        int j = mid + 1;
        int k = low;

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
