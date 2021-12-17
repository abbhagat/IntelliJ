package sorting;

import static java.util.stream.IntStream.range;

public class SortArrayContainingOnlyZerosAndOnes {

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0};
        int countZero = 0;
        for (int x : a) {
            if (x == 0) {
                countZero++;
            }
        }
        final int c = countZero;
        range(0, a.length).forEach(i -> a[i] = (i < c) ? 0 : 1);
        range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
