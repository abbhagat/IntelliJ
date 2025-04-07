package pairs;

// Time  Complexity : O(n + k)
// Space Complexity : O(k)
public class FindPairCountWithSumDivisibleByK {

    private static int countPairs(int[] a, int k) {
        int[] freq = new int[k];
        for (int x : a) {
            freq[x % k]++;  // keeps the count of each remainder
        }
        int count = freq[0] * (freq[0] - 1) / 2;
        for (int i = 1; i <= k / 2 && i != (k - i); i++) {
            count += freq[i] * freq[k - i];
        }
        count += k % 2 == 0 ? freq[k / 2] * (freq[k / 2] - 1) / 2 : 0;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1, 2, 3, 4, 5, 8}, 5));
        System.out.println(countPairs(new int[]{2, 2, 1, 7, 5, 3}, 4));
        System.out.println(countPairs(new int[]{2, 3, 5, 10}, 5));
    }
}
