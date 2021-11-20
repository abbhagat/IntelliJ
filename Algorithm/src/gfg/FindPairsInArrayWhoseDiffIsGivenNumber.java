package gfg;

import java.util.HashSet;
import java.util.Set;

public class FindPairsInArrayWhoseDiffIsGivenNumber {

    private static void findPairs(int[] a, int target) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        for (int x : a) {
            int y = x - target;
            if (set.contains(y)) {
                System.out.println("(" + x + "," + y + ")");
            }
        }
    }

    public static void main(String[] args) {
        findPairs(new int[]{2, 6, 7, 1, 8, 3, 5, 5, 4, 5}, 4);
        System.out.println();
        findPairs(new int[]{10, 5, 15, 5, 0}, 5);
        System.out.println();
        findPairs(new int[]{10, 5, 15}, 5);
        System.out.println();
        findPairs(new int[]{10, 5, 15, 5, 0}, 0);
    }
}
