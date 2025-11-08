package dynamicProgramming;


import static java.lang.Integer.max;

/**
 * The House Robber Problem states that, in a neighborhood in a city, there is a single row of n houses.
 * A thief is planning to carry a heist in this neighborhood. He knows how much gold is concealed in each of the houses.
 * However, in order to avoid triggering an alarm and raise suspicion, he plans to carry heist in such a way that no two consecutive houses are looted.
 * i.e., if the house at index = i is looted, the houses at i-1 and i+1 are not looted.
 * Find out the maximum amount of gold the thief can steal following the given constraints.
 * Input 1: arr[] = [2,3,4,2,3]
 * Maximum gold = [2, X, 4, X, 3] = 9
 * Output: 6
 * Input 2: arr[] = [3,8,10,4,2,3]
 * Maximum gold = [3, X, 10, X, X, 3] = 16
 * Output: 16
 * Input 2: arr[] = [3,8,10,4,2,3,11]
 * Maximum gold = [3, X, 10, X, 2, X, 11] = 26
 * Output: 26
 * Explanation: in example 2, the thief has to get to 1st, 3rd, and 6th house to collect the maximum number of gold given the constraints.
 * Start traversing arr[] from right to left.
 * If an element arr[i] is selected then the next element (arr[i-1]) cannot be selected.
 * If an element(arr[i]) is not selected then the next element arr[i-1] can be selected.
 * Perform steps 2 and 3 recursively and return the maximum of values obtained in steps 2 and 3.
 */
public class HouseRobberProblem {

    private static int maxGoldLooted(int[] a, int n) {
        if (n <= 0) {
            return 0;
        }
        int selected = maxGoldLooted(a, n - 2) + a[n - 1];
        int unselected = maxGoldLooted(a, n - 1);
        return max(selected, unselected);
    }

    private static int maxGoldLooted(int[] a) {
        int incl = a[0], excl = 0;
        for (int i = 1; i < a.length; i++) {
            int excl_new = max(incl, excl);
            incl = excl + a[i];
            excl = excl_new;
        }
        return max(incl, excl);
    }

    private static int maxGoldLootedDP(int[] a) {
        int n = a.length;
        int[] dp = new int[n];   // dp[i] represent the maximum value stolen so far after reaching the house 'i'
        dp[0] = a[0];
        dp[1] = max(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = max(dp[i - 1], a[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 7, 1, 3, 8, 2, 4};
        System.out.println(maxGoldLooted(a, a.length) + "\t" + maxGoldLootedDP(a) + "\t" + maxGoldLooted(a));
        a = new int[]{5, 3, 4, 11, 2};
        System.out.println(maxGoldLooted(a, a.length) + "\t" + maxGoldLootedDP(a) + "\t" + maxGoldLooted(a));
        a = new int[]{3, 5, 7};
        System.out.println(maxGoldLooted(a, a.length) + "\t" + maxGoldLootedDP(a) + "\t" + maxGoldLooted(a));
    }
}
