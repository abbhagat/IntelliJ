package sorting;

import java.util.stream.IntStream;
import static util.CommonUtils.swap;

// Time Complexity O(n log n)
public class QuickSortString {

    private static final String[] a = {"Ani", "Sam", "Joe"};

    private static void quickSort(int low, int high) {
        int i = low;
        int j = high;
        String key = a[(i + j) / 2];
        while (a[i].compareTo(key) > 0) {
            i++;
        }
        while (a[j].compareTo(key) < 0) {
            j--;
        }
        if (i <= j) {
            swap(a, i, j);
            i++;
            j--;
        }
        if (i < high) {
            quickSort(i, high);
        }
        if (j > low) {
            quickSort(low, j);
        }
    }

    public static void main(String[] args) {
        quickSort(0, a.length - 1);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
