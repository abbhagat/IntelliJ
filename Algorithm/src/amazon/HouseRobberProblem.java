package amazon;


import static java.lang.Integer.max;

/**
 * The House Robber Problem states that, in a neighborhood in a city, there is a single row of n houses.
 * A thief is planning to carry a heist in this neighborhood. He knows how much gold is concealed in each of the houses.
 * However, in order to avoid triggering an alarm and raise suspicion, he plans to carry heist in such a way that no two consecutive houses are looted.
 * i.e. if the house at index = i is looted, the houses at i-1 and i+1 are not looted.
 * <p>
 * Find out what is the maximum number of gold the thief can steal following the given constraints.
 * <p>
 * Input 1: arr[] = [2,3,4,2,3]
 * Maximum gold = [2, X, 4, X, 3] = 9
 * Output: 6
 * Input 2: arr[] = [3,8,10,4,2,3]
 * Maximum gold = [3, X, 10, X, X, 3] = 16
 * Output: 16
 * Input 2: arr[] = [3,8,10,4,2,3,11]
 * Maximum gold = [3, X, 10, X, 2, X, 11] = 26
 * Output: 26
 * <p>
 * Explanation: in example 2, the thief has to get to 1st, 3rd, and 6th house to collect the maximum number of gold given the constraints.
 * <p>
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
        int selected   = a[n - 1] + maxGoldLooted(a, n - 2);
        int unselected = maxGoldLooted(a, n - 1);
        return max(selected, unselected);
    }

    private static int maxGoldLootedDP(int[] a, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return a[0];
        }
        if (n == 2) {
            return max(a[0], a[1]);
        }
        int table[] = new int[n];          // table[i] represent the maximum value stolen so far after reaching house i.
        table[0] = a[0];                  // Initialize the table[0] and table[1]
        table[1] = max(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            table[i] = max(a[i] + table[i - 2], table[i - 1]);      // Fill remaining positions
        }
        return table[n - 1];
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 10, 4, 2, 3};
        System.out.println("Max Gold Looted :" + maxGoldLooted(a, a.length));
        System.out.println("Max Gold Looted :" + maxGoldLootedDP(a, a.length));
        int[] b = {2,3,4,2,3};
        System.out.println("Max Gold Looted :" + maxGoldLooted(b, b.length));
        System.out.println("Max Gold Looted :" + maxGoldLootedDP(b, b.length));
    }
}
