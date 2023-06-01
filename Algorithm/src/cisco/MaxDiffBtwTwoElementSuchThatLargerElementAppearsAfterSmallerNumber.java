package cisco;


/**
 * Input : a = {2, 3, 10, 6, 4, 8, 1}
 * Output : 8
 * Explanation : The maximum difference is between 10 and 2.
 * <p>
 * Input : a = {7, 9, 5, 6, 3, 2}
 * Output : 2
 * Explanation : The maximum difference is between 9 and 7.
 */

// Time Complexity : O(n)
// Auxiliary Space : O(1)
public class MaxDiffBtwTwoElementSuchThatLargerElementAppearsAfterSmallerNumber {

    private static int maxDiff(int[] a) {
        int diff = a[1] - a[0];
        int curr_sum = diff;
        int max_sum = curr_sum;
        for (int i = 1; i < a.length - 1; i++) {
            diff = a[i + 1] - a[i];
            curr_sum = curr_sum > 0 ? curr_sum + diff : diff;
            max_sum  = curr_sum > max_sum ? curr_sum : max_sum;
        }
        return max_sum;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[] {2, 3, 10, 6, 4, 8, 1}));
        System.out.println(maxDiff(new int[] {7, 9, 5, 6, 3, 2}));
    }
}
