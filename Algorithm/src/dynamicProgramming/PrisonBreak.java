package dynamicProgramming;

/*
Programmer Sam is planning to escape from prison! The prison's gate consists of horizontal and vertical bars that are spaced one unit apart,
so the area of each hole between the bars is 1 × 1. Sam manages to remove certain bars and make some of these holes bigger.
Determine the area of the largest hole in the gate after the bars are removed.
For example, consider the diagram below. The left image depicts the initial prison gate with n = 6 horizontal and m = 6 vertical bars,
where the area of the biggest hole in the bars is 1 × 1. The right image depicts that same gate after Sam removes horizontal bar 4 and
vertical bar 2, at which point the area of the biggest hole in the bars becomes 2 × 2 = 4:
Function Description Completes the function prison in the editor below. The function must return a long integer denoting the area of the biggest hole
in the prison gate's bars.
prison has the following parameter(s): n: integer, the number of horizontal bars initially m: integer, the number of vertical bars initially h[h[0],...h[x-1]]: an array of integers, the horizontal bars to remove v[v[0],...v[y-1]]: an array of integers, the vertical bars to remove
Constraints 1 ≤ n, m ≤ 105 0 ≤ x ≤ n 0 ≤ y ≤ m 1 ≤ h[i] ≤ n, where 1 ≤ i ≤ n. 1 ≤ v[j] ≤ m, where 1 ≤ j ≤ m. It is guaranteed that values in array h are distinct. It is guaranteed that values in array v are distinct.
Input Format for Custom Testing Input from stdin will be processed as follows and passed to the function.
The first line contains an integer n. The second line contains an integer m. The third line contains an integer x, the size of the array h.
Each of the next x lines contains an integer h[i] where 0 ≤ i < n. The next line contains an integer y, the size of the array v.
Each of the next v lines contains an integer v[j] where 0 ≤ j < m.
Sample Case 0 Sample Input 0 3 3 1 2 1 2
Sample Output 0 4
Explanation 0 Bar counts are h = [2] and v = [2]. This means that Sam removes horizontal bar 2 and vertical bar 2 from the gate, so it looks like this:
*/

import java.util.Arrays;
import java.util.List;
import static java.lang.Integer.max;

public class PrisonBreak {

    public static long prison(int m, int n, List<Integer> h, List<Integer> v) {
        boolean[] x = new boolean[m + 1];
        boolean[] y = new boolean[n + 1];
        int cx = 0, cy = 0,  max_X = Integer.MIN_VALUE, max_Y = Integer.MIN_VALUE;
        for (int k : h) {
            x[k] = true;
        }
        for (int k : v) {
            y[k] = true;
        }
        for (boolean b : x) {
            if (b) {
                cx++;
                max_X = max(max_X, cx);
            } else {
                cx = 0;
            }
        }
        for (boolean b : y) {
            if (b) {
                cy++;
                max_Y = max(max_Y, cy);
            } else {
                cy = 0;
            }
        }
        return (long) (max_X + 1) * (max_Y + 1);
    }

    public static void main(String[] args) {
        System.out.println(prison(3, 3, List.of(2), List.of(2)));
        System.out.println(prison(3, 2, Arrays.asList(1, 2, 3), Arrays.asList(1, 2)));
    }
}
