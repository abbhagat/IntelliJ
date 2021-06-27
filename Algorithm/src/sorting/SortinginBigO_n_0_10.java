package sorting;

import java.util.stream.IntStream;

/**
 * I/P :- int[] a = { 4, 3, 2, 0, 1, 8, 9, 7, 10, 5, 6 }
 * <p>
 * O/P :- int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
 * <p>
 * Both the array has to be sorted in O(n).
 */

public class SortinginBigO_n_0_10 {

    static int[] a = {4, 3, 2, 0, 1, 8, 9, 7, 10, 5, 6};

    static int swap(int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
        return i;
    }

    public static void main(String[] args) {
        for (int i = 0; i < a.length; i = (i != a[i]) ? swap(i, a[i]) : ++i) ;
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
