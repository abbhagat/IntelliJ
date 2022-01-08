package geeks;

import static java.lang.Integer.max;

/**
 * Input : arr[] = {5, 5, 10, 100, 10, 5}
 * Output : 110
 * <p>
 * Input : arr[] = {1, 2, 3}
 * Output : 4
 * <p>
 * Input : arr[] = {1, 20, 3}
 * Output : 20
 * <p>
 * Loop the arr[] and maintain two sums incl and excl
 * <p>
 * incl = Max sum including the previous element
 * excl = Max sum excluding the previous element
 * <p>
 * Max sum excluding the current element will be max(incl, excl) and
 * Max sum including the current element will be excl + current element
 * <p>
 * (Note that only excl is considered because elements cannot be adjacent).
 * <p>
 * At the end of the loop return max of incl and excl.
 */

// Maximum sum such that no two elements are adjacent
public class MaxSumNonAdjacentArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int incl = a[0], excl = 0, excl_new;
        for (int i = 1; i < a.length; i++) {
            excl_new = max(incl, excl);
            incl = excl + a[i];
            excl = excl_new;
        }
        System.out.println(max(incl, excl));
    }
}
