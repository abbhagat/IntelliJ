package pairs;

import util.Pair;

import java.util.*;

public class FindPairsInArrayWhoseDiffIsGivenNumber {

    // Time  Complexity : O(n)
    // Space Complexity : O(n)
    private static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Pair> set = new HashSet<>();
        Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        Arrays.stream(a).forEach(x -> {
             int y = x - target;
             if (map.containsKey(y) && (map.get(y) > 1 || target != 0)) {
                   set.add(new Pair(x, y));
             }
        });
        System.out.println(set);
    }

    // Time  Complexity : O(n log n)
    // Space Complexity : O(n)
    private static void findPair(int[] a, int target) {
        Arrays.sort(a);
        int i = 0, j = 0, n = a.length - 1;
        while (i <= n && j <= n) {
            while (i < n && a[i] == a[i + 1]) {  // to avoid printing duplicates
                i++;
            }
            while (j < n && a[j] == a[j + 1]) {
                j++;
            }
            if (a[j] - a[i] > target) {
                i++;
            } else if (a[j] - a[i] < target) {
                j++;
            } else {
                System.out.println("(" + a[i] + ", " + a[j] + ")");
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        findPairs(new int[]{2, 6, 7, 1, 8, 3, 5, 5, 4, 5}, 4);
        System.out.println();
        findPair(new int[]{2, 6, 7, 1, 8, 3, 5, 5, 4, 5}, 4);
        System.out.println("**********************");
        findPairs(new int[]{10, 5, 15, 5, 0}, 5);
        System.out.println();
        findPair(new int[]{10, 5, 15, 5, 0}, 5);
        System.out.println("**********************");
        findPairs(new int[]{10, 5, 15}, 5);
        System.out.println();
        findPair(new int[]{10, 5, 15}, 5);
        System.out.println("**********************");
        findPairs(new int[]{10, 5, 15, 5, 0}, 0);
        System.out.println();
        findPair(new int[]{10, 5, 15, 5, 0}, 0);
        System.out.println("**********************");
        findPairs(new int[]{1, 3}, 2);
        System.out.println();
        findPair(new int[]{1, 3}, 2);
        System.out.println("**********************");
        findPairs(new int[]{5, 0}, 5);
        System.out.println();
        findPair(new int[]{5, 0}, 5);
        System.out.println("**********************");
        findPairs(new int[]{5, 5, 5}, 0);
        System.out.println();
        findPair(new int[]{5, 5, 5}, 0);
        System.out.println("**********************");
    }
}
