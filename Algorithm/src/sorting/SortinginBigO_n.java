package sorting;

/**
 * I/P :- int[] a = {14, 13, 12, 11, 18, 19, 17, 20, 15, 16}
 * <p>
 * O/P :- int[] a = {11 12 13 14 15 16 17 18 19 20};
 * <p>
 * Both the array has to be sorted in O(n).
 */

public class SortinginBigO_n {

    static int[] a = {14, 13, 12, 11, 18, 19, 17, 20, 15, 16};

    static int swap(int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
        return i;
    }

    public static void main(String[] args) {
        int min = a[0];
        for (int x : a) {
            if (min > x) {
                min = x;
            }
        }
        for (int i = 0; i < a.length; i++) {
            a[i] -= min;
        }
        // Actual Sorting
        for (int i = 0; i < a.length; i = (i != a[i]) ? swap(i, a[i]) : ++i) ;

        for (int i = 0; i < a.length; i++) {
            a[i] += min;
        }
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}