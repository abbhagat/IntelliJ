package geeksforgeeks;

/**
 * Programmer Sam is planning to escape from prison! The prison's gate consists of horizontal and vertical bars that are spaced one unit apart,
 * so the area of each hole between the bars is 1 × 1. Sam manages to remove certain bars and make some of these holes bigger.
 * Determine the area of the largest hole in the gate after the bars are removed.
 * <p>
 * For example, consider the diagram below. The left image depicts the initial prison gate with n = 6 horizontal and m = 6 vertical bars,
 * where the area of the biggest hole in the bars is 1 × 1. The right image depicts that same gate after Sam removes horizontal bar 4 and
 * vertical bar 2, at which point the area of the biggest hole in the bars becomes 2 × 2 = 4:
 * <p>
 * Function Description Complete the function prison in the editor below. The function must return a long integer denoting the area of the biggest hole
 * in the prison gate's bars.
 * <p>
 * prison has the following parameter(s): n: integer, the number of horizontal bars initially m: integer, the number of vertical bars initially h[h[0],...h[x-1]]: an array of integers, the horizontal bars to remove v[v[0],...v[y-1]]: an array of integers, the vertical bars to remove
 * <p>
 * Constraints 1 ≤ n, m ≤ 105 0 ≤ x ≤ n 0 ≤ y ≤ m 1 ≤ h[i] ≤ n, where 1 ≤ i ≤ n. 1 ≤ v[j] ≤ m, where 1 ≤ j ≤ m. It is guaranteed that values in array h are distinct. It is guaranteed that values in array v are distinct.
 * <p>
 * Input Format for Custom Testing Input from stdin will be processed as follows and passed to the function.
 * <p>
 * The first line contains an integer n. The second line contains an integer m. The third line contains an integer x, the size of the array h.
 * Each of the next x lines contains an integer h[i] where 0 ≤ i < n. The next line contains an integer y, the size of the array v.
 * Each of the next v lines contains an integer v[j] where 0 ≤ j < m.
 * <p>
 * Sample Case 0 Sample Input 0 3 3 1 2 1 2
 * <p>
 * Sample Output 0 4
 * <p>
 * Explanation 0 Bar counts are h = [2] and v = [2]. This means that Sam removes horizontal bar 2 and vertical bar 2 from the gate, so it looks like this:
 */


import java.util.Arrays;
import java.util.List;

public class PrisonBreak {

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        boolean[] x = new boolean[n + 1];
        boolean[] y = new boolean[m + 1];

        int cx = 0, cy = 0;
        int ox = Integer.MIN_VALUE;
        int oy = Integer.MIN_VALUE;

        for (int i = 0; i < h.size(); i++) {
            x[h.get(i)] = true;
        }

        for (int i = 0; i < v.size(); i++) {
            y[v.get(i)] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (x[i]) {
                cx++;
                ox = Math.max(ox, cx);

            } else {
                cx = 0;
            }
        }
        for (int i = 1; i <= m; i++) {
            if (y[i]) {
                cy++;
                oy = Math.max(oy, cy);
            } else {
                cy = 0;
            }
        }
        return (ox + 1) * (oy + 1);

    }

    public static void main(String[] args) {
        System.out.println(prison(6, 6, Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 6)));
    }
}
