package pairs;

import java.util.*;
import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class FindPairsInArrayWhoseSumIsDivisibleByGivenNumber {

    private static void findPairs(int[] a, int k) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((a[i] + a[j]) % k == 0) {
                    int min = min(a[i], a[j]);
                    int max = max(a[i], a[j]);
                    String pair = min + "," + max;
                    if (set.add(pair)) {
                        System.out.println("(" + min + "," + max + ")");
                        count++;
                    }
                }
            }
        }
        System.out.println("Pair Count : " + count);
    }

    private static void findPairCount(int[] a, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int num : a) {
            int rem = num % k;
            int complement = (k - rem) % k;
            count += freq.getOrDefault(complement, 0);
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }
        System.out.println("Pair Count : " + count);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 10};
        findPairs(a, 5);
        findPairCount(a, 5);
    }
}
