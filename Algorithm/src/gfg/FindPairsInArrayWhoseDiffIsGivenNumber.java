package gfg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPairsInArrayWhoseDiffIsGivenNumber {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (null == obj || this.getClass() != obj.getClass()) {
                return false;
            }
            final Pair p = (Pair) obj;
            return p.x == this.x && p.y == this.y;
        }

        public int hashCode() {
            final int prime = 31;
            int hashCode = 1;
            hashCode = prime * hashCode + this.x;
            hashCode = prime * hashCode + this.y;
            return hashCode;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    private static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Pair> set = new HashSet<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : a) {
            int y = x - target;
            if (map.containsKey(y) && ((target == 0 && map.get(y) > 1) || target != 0)) {
                set.add(new Pair(x, y));
            }
        }
        System.out.println(set);
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
