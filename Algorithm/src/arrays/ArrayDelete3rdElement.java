package arrays;

import java.util.stream.IntStream;

public class ArrayDelete3rdElement {

    private static void modifyArray(int[] a, int pos) {
        pos -= 1;
        int n = a.length, i = pos;
        while (i < n) {
            System.arraycopy(a, i + 1, a, i, n - i - 1);
            n--;
            i += pos;
        }
        IntStream.range(i - 1, a.length).forEach(j -> a[j] = 0);
        IntStream.range(0, a.length).forEach(j -> System.out.print(a[j] + " "));
    }

    public static void main(String[] args) {
        modifyArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2);
        System.out.println();
        modifyArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
    }
}
