package pairs;

import java.util.Arrays;

public class CountPairsWhoseSumIsLessThanAGivenNumber {

    private static int countPairs(int[] a, int n) {
        Arrays.sort(a);
        int i = 0, j = a.length - 1, count = 0;
        while (i < j) {
            if (a[i] + a[j] < n) {
                count += j - i;  // All pairs between i and j are valid
            }
            int k = a[i] + a[j] < n ? i++ : j--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{2, 3, 5, 6}, 16));
        System.out.println(countPairs(new int[]{1, 3, 4, 2, 1}, 5));
    }
}
