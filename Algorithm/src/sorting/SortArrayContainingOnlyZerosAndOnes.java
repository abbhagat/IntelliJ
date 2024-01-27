package sorting;

import java.util.stream.IntStream;

import static util.CommonUtils.swap;

public class SortArrayContainingOnlyZerosAndOnes {

    public static void main(String[] args) {
        final int[] a = {1, 0, 0, 1, 0, 1, 0, 1, 0, 1};
        for (int j = 0, i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                swap(a, i, j);
                j++;
            }
        }
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
