package arrays;

import java.util.stream.IntStream;

public class ArrayDelete3rdElement {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = a.length, pos = 3;
        for (int i = --pos; i < n - 1; i += pos) {
            System.arraycopy(a, i + 1, a, i, n - i - 1);
            n--;
        }
        IntStream.range(0, n).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
    }
}
