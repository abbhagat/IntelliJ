package arrays;

public class MaxSubsequence {

    static int[] arr = {1, 18, 12, 3, 95};

    public static int longestIncreasingSubsequenceSum() {

        // populate the lists of lengths
        int[] lengths = new int[arr.length];
        int[] sums = new int[arr.length];
        int bestLength = 0;
        int bestSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j > -1; j--) {
                if (arr[j] < arr[i] && lengths[j] > lengths[i]) {
                    lengths[i] = lengths[j];
                    sums[i] = sums[j];
                }
            }
            lengths[i]++;
            sums[i] += arr[i];
            if (lengths[i] > bestLength) {
                bestLength = lengths[i];
                bestSum = sums[i];
            }
        }

        return bestSum;
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequenceSum());
    }
}
