package sorting;

import java.util.stream.IntStream;

import static util.CommonUtils.swap;

/**
 * I/P :- int[] a = { 4, 3, 2, 0, 1, 8, 9, 7, 10, 5, 6 }
 * <p>
 * O/P :- int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
 * <p>
 * Both the array has to be sorted in O(n).
 */

public class SortingBigO_n_0_10 {

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 0, 1, 8, 9, 7, 10, 5, 6};
        int i = 0;
        while (i < a.length) {
            if (a[i] != i) {
                swap(a, i, a[i]);
            } else {
                i++;
            }
        }
        IntStream.range(0, a.length).forEach(j -> System.out.print(a[j] + " "));
    }
}
