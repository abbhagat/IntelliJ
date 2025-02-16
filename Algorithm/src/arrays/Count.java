package arrays;

import java.util.stream.IntStream;

public class Count {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1};
        int countZero = 0;
        for (int x : a) {
            if (x == 0) {
                countZero++;
            }
        }
        final int k = countZero;
        IntStream.range(0, a.length).forEach(i -> a[i] = i < k ? 0 : 1);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
