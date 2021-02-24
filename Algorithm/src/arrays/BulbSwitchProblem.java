package arrays;

/**
 * Given two arrays switch[], consisting of binary integers denoting whether a switch is ON(0) or OFF(1).
 * And query[], where query[i] denotes the switch to be toggled.
 * The task after completing all the switch toggles is to print the number of times the bulb changes its state, i.e. from ON to OFF or vice-versa.
 * <p>
 * Input: switch[] ={1, 1, 0}, query[] = {3, 2, 1}
 * Output : 1
 * Explanation:
 * Initial state of switches {1, 1, 0}. Since the count of 1’s = 2 (>= ceil(N / 2)), the bulb glows.
 * query[0] = 3
 * Next state of switches {1, 1, 1}. Since the count of 1’s = 3 (>= ceil(N / 2)), the bulb glows.
 * query[1] = 2
 * Next state of switches {1, 0, 1}. Since the count of 1’s = 2 (>= ceil(N / 2)), the bulb glows.
 * query[2] = 1
 * Next state of switches {0, 0, 1}.. Since the count of 1’s = 1 (< ceil(N / 2)), the bulb turns off.
 * Therefore, the bulb switches from glowing to non-glowing state only once.
 * <p>
 * Input : switch[] = { 1, 1, 0, 0, 1, 1 }
 * query[] = { 4, 3, 6 }
 * Output: 0
 * <p>
 * Solution:-
 * <p>
 * Traverse the array arr[].
 * Count the number of 1s to keep track of the initial state of the bulb.
 * Traverse the array query[].
 * For every query[i], update arr[] and the count of 1s. Check for the current state of the bulb accordingly.
 * If the previous and the current states are found to be different, then increment count.
 * Finally, print the value of count.
 */
public class BulbSwitchProblem {

    private static int[] a = {1, 1, 0, 0, 1, 1};
    private static int[] q = {4, 3, 6};

    private static int solve() {
        int countOne = 0;
        for (int x : a) {
            if (x == 1)
                countOne++;
        }
        int count = 0;
        int glows = (countOne >= (int) Math.ceil(a.length / 2)) ? 1 : 0;
        for (int i = 0; i < q.length; i++) {
            int prev = glows;
            if (a[q[i] - 1] == 1) {
                countOne--;
            }
            if (a[q[i] - 1] == 0) {
                countOne++;
            }
            a[q[i] - 1] ^= 1;
            glows = (countOne >= (int) Math.ceil(a.length / 2)) ? 1 : 0;
            if (prev != glows) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
