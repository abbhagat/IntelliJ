package sorting;

import java.util.stream.IntStream;

import static util.CommonUtils.swap;

// Time Complexity O(n log n)

public class QuickSort {
    private static void quickSort(int[] a, int low, int high) {
        int i = low, j = high;
        int key = a[(i + j) / 2];
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
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
