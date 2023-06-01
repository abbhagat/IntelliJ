package sorting;

import java.util.stream.IntStream;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {20, 3, 15, 6, 9, 8, 2, 1, 6, 8, 7, 15};
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
        for (int i = 1; i < a.length; i++) {
             int j = i - 1;
             while (j >= 0 && a[j] > a[j + 1]) {
                int t = a[j];
                a[j] = a[j + 1];
                a[j + 1] = t;
                j--;
             }
         }
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
