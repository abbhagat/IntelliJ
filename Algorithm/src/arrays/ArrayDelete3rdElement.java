package arrays;

import java.util.stream.IntStream;

public class ArrayDelete3rdElement {

    private static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int n = a.length;

    private static void  deleteElement(int pos) {
        for (int i = pos; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        n--;
    }

    public static void main(String[] args) {
        int pos = 3;
        for (int i = --pos; i < n; i += pos) {
            deleteElement(i);
        }
        IntStream.range(0, n).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
    }
}
