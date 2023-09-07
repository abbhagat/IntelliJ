package geeks;

import static java.lang.Integer.max;

public class MaxSumNonAdjacentArray {

    private static int maxSumNonAdjacentArray(int[] a) {
        int incl = a[0], excl = 0;
        for (int i = 1; i < a.length; i++) {
            int excl_new = max(incl, excl);
            incl = excl + a[i];
            excl = excl_new;
        }
        return max(incl, excl);
    }

    public static void main(String[] args) {
        System.out.println(maxSumNonAdjacentArray(new int[] {1, 2, 3}));
        System.out.println(maxSumNonAdjacentArray(new int[] {1, 20, 3}));
        System.out.println(maxSumNonAdjacentArray(new int[] {5, 5, 10, 100, 10, 5}));
    }
}
