package sorting;

import java.util.stream.IntStream;

public class QuickSort {

    private static int[] a = {10, 3, 4, 6, 9, 2, 1, 5, 8, 7};

    private static void quickSort(int low, int high) {
        int i = low;
        int j = high;
        int key = a[(i + j) / 2];
        while (i <= j) {
            while (a[i] < key) {
                i++;
            }
            while (a[j] > key) {
                j--;
            }
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }
        if (i < high) {
            quickSort(i, high);
        }
        if (j > low) {
            quickSort(low, j);
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        quickSort(0, a.length - 1);
        System.out.println();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
