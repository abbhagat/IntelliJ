package amazon;

/*
  I/P :- int[] a = { 4, 3, 2, 0, 1 }; char[] c = { 'e', 'd', 'c', 'a', 'b' };
  O/P :- int[] a = { 0, 1, 2, 3, 4 }; char[] c = { 'a', 'b', 'c', 'd', 'e' };
  Both the array has to be sorted in O(n).
 */

import static util.CommonUtils.swap;

// Time  Complexity  O(n)
public class SortingInBigO_n {

    private static void sort(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (i != a[i]) {
                swap(a, i, a[i]);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[]  a  = {4, 3, 2, 0, 1};
        sort(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
