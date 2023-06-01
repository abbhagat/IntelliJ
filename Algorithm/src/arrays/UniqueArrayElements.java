package arrays;

/*
 * Find the unique number that is present only once in array
 * while all the others are present three times.
 */

/*
 * Soln 1 :  using a hashmap
 * Soln 2 : O(n^2)
 * Soln 3 : Using Sorting
 */

public class UniqueArrayElements {

    private static int[] a = {2, 3, 5, 1, 2, 2, 5, 4, 3, 5, 3, 4, 2};

    public static void main(String[] args) {
        int[] temp = new int[a.length];
        int i;
        for (i = 0; i < a.length; i++) {
            temp[a[i]]++;
        }
        for (i = 0; i < a.length; i++) {
            if (temp[i] == 1) {
                System.out.println(i + " is present once");
            }
            if (temp[i] == 3) {
                System.out.println(i + " is present three times");
            }
        }
    }
}
