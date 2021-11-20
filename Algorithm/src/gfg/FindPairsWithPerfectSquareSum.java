package gfg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairsWithPerfectSquareSum {

    private static int a[] = {2, 3, 6, 9, 10, 20};

    public static List<Integer> getPerfectSquares(int sum) {
        List<Integer> perfectSquares = new ArrayList<>();
        int n = 1, i = 1;
        while (n < sum) {
            perfectSquares.add(n);
            n = (int) Math.pow(++i, 2);
        }
        return perfectSquares;
    }

    public static int maxPairSum() {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int x : a) {
            if (max < x) {
                secondMax = max;
                max = x;
            } else if (secondMax < x) {
                secondMax = x;
            }
        }
        return (max + secondMax);
    }

    public static int countPairsWith(int x, List<Integer> perfectSquares, Set<Integer> set) {
        int count = 0;
        for (int target : perfectSquares) {
            int y = target - x;
            if (y > x && set.contains(y)) {  // y > x is checked so that pairs (x, y) and (y, x) don't get counted twice
                System.out.println(x + "," + y);
                count++;
            }
        }
        return count;
    }

    public static int countPairs() {
        int sum = maxPairSum();
        List<Integer> perfectSquares = getPerfectSquares(sum);
        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        int count = 0;
        for (int x : a) {
            count += countPairsWith(x, perfectSquares, set);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPairs());
    }
}
