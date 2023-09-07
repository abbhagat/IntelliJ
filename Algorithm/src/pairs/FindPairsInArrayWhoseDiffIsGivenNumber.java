package pairs;

import util.Pair;

import java.util.*;

public class FindPairsInArrayWhoseDiffIsGivenNumber {

    private static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Pair> set = new HashSet<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : a) {
            int y = x - target;
            if (map.get(y) != null && (map.get(y) > 1 || target != 0)) {
                 set.add(new Pair(x, y));
            }
        }
         System.out.println(set);
    }

    private static void findPair(int[] a, int diff) {
        Arrays.sort(a);
        int i = 0, j = 0, n = a.length - 1;
        while (i <= n && j <= n) {
            while (i < n && a[i] == a[i + 1]) {  // to avoid printing duplicates
                i++;
            }
            while (j < n && a[j] == a[j + 1]) {
                j++;
            }
            if (a[j] - a[i] > diff) {
                i++;
            } else if (a[j] - a[i] < diff) {
                j++;
            } else {
                System.out.println("(" + a[j] + ", " + a[i] + ")");
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
