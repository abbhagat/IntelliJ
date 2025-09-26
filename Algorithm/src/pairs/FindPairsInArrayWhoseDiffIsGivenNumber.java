package pairs;

import java.util.*;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class FindPairsInArrayWhoseDiffIsGivenNumber {

    public static void findPairs(int[] a, int k) {
        Set<Integer> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int x : a) {
            if (set.contains(x - k)) {
                result.add("(" + x + "," + (x - k) + ")");
            }
            if (set.contains(x + k)) {
                result.add("(" + x + "," + (x + k) + ")");
            }
            set.add(x);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        findPairs(new int[]{2, 6, 7, 1, 8, 3, 5, 5, 4, 5}, 4);
        findPairs(new int[]{10, 5, 15, 5, 0}, 5);
        findPairs(new int[]{10, 5, 15}, 5);
        findPairs(new int[]{10, 5, 15, 5, 0}, 0);
        findPairs(new int[]{1, 3}, 2);
        findPairs(new int[]{5, 0}, 5);
        findPairs(new int[]{5, 5, 5}, 0);
    }
}
