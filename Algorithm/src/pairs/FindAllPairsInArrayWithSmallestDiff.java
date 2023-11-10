package pairs;

import java.util.Arrays;

import static java.lang.Integer.min;

public class FindAllPairsInArrayWithSmallestDiff {

    private static void findMaxPairDiff(int[] a) {
        Arrays.sort(a);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            max = Integer.max(max, a[i] - a[i - 1]);
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == max) {
                System.out.println(a[i - 1] + "," + a[i]);
            }
        }
        System.out.println();
    }

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
        System.out.println();
    }

    public static void main(String[] args) {
        findPairs(new int[]{6, 2, 4, 10});
        findMaxPairDiff(new int[]{6, 2, 4, 10});
        findPairs(new int[]{5, 4, 3, 2});
        findPairs(new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854});
    }
}
