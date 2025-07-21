package pairs;

import java.util.Arrays;

import static java.lang.Integer.min;

// Time  Complexity : O(n log n)
// Space Complexity : O(1)
public class FindAllPairsInArrayWithSmallestDiff {

    private static void findPairs(int[] a) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            min = min(min, a[i] - a[i - 1]);
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == min) {
                System.out.println(a[i - 1] + "," + a[i]);
            }
        }
    }

    public static void main(String[] args) {
        findPairs(new int[]{6, 2, 4, 10});
        findPairs(new int[]{5, 4, 3, 2});
        findPairs(new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854});
        findPairs(new int[]{1, 2,3, 4});
        findPairs(new int[]{1, 1, 2, 1, 2, 3});
        findPairs(new int[]{1, 7, 11,2, 4, 6});
    }
}
