package arrays;

import java.util.stream.IntStream;

public class ArrayDelete3rdElement {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = a.length, pos = 3;
        pos -= 1;
        int i = pos;
        while (i < n) {
            System.arraycopy(a, i + 1, a, i, n - i - 1);
            n--;
            i += pos;
        }
        IntStream.range(i - 1, a.length).forEach(j -> a[j] = 0);
        IntStream.range(0, a.length).forEach(j -> System.out.print(a[j] + " "));
    }
}
