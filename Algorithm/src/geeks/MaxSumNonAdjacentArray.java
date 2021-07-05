package geeks;

/*

Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20

Loop the arr[] and maintain two sums incl and excl

incl = Max sum including the previous element
excl = Max sum excluding the previous element

Max sum excluding the current element will be max(incl, excl) and
Max sum including the current element will be excl + current element

(Note that only excl is considered because elements cannot be adjacent).

At the end of the loop return max of incl and excl.
*/

//Maximum sum such that no two elements are adjacent
public class MaxSumNonAdjacentArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int incl = a[0], excl = 0;
        for (int i = 1; i < a.length; i++) {
            int excl_new = Math.max(incl, excl);  /* current max excluding i */
            incl = excl + a[i];                  /* current max including i */
            excl = excl_new;
        }
        System.out.println(Math.max(incl, excl));  /* return max of incl and excl */
    }
}
