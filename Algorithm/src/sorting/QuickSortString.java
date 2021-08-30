package sorting;

import java.util.stream.IntStream;

public class QuickSortString {

    private static String[] a = {"Ani", "Sam", "Joe"};

    private static void quickSort(int low, int high) {
        int i = low;
        int j = high;
        String key = a[(i + j) / 2];
        while (i <= j) {
            while (a[i].compareTo(key) > 0) {
                i++;
            }
            while (a[j].compareTo(key) < 0) {
                j--;
            }
            if (i <= j) {
                String t = a[i];
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
