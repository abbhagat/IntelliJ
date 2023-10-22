package arrays;

import java.util.stream.IntStream;

public class ArrayDelete3rdElement {

    private static void modifyArray(int[] a, int pos) {
        pos--;
        int n = a.length;
        for (int i = pos; i < n; i += pos) {
            System.arraycopy(a, i + 1, a, i, n - i - 1);
            n--;
        }
        IntStream.range(n, a.length).forEach(i -> a[i] = 0);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }

    public static void main(String[] args) {
        modifyArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2);
        System.out.println();
        modifyArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
    }
}
