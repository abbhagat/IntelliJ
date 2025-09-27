package pairs;

import java.util.*;
import java.util.stream.Collectors;

// Time Complexity: O(n * sqrt(sum))   [ O(n) + O(√sum) + O(n * m) ]
// Space Complexity: O(√sum) + O(n)
public class FindPairsWithPerfectSquareSum {

    public static List<Integer> getPerfectSquares(int sum) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i * i < sum ; i++) {
            list.add(i * i);
        }
        return list;
    }

    public static int maxPairSum(int[] a) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int x : a) {
            if (max < x) {
                secondMax = max;
                max = x;
            } else if (secondMax < x) {
                secondMax = x;
            }
        }
        return max + secondMax;
    }

    public static int countPairs(int x, List<Integer> list, Set<Integer> set) {
        int count = 0;
        for (int target : list) {
             int y = target - x;
             if (y > x && set.contains(y)) {       // y > x is checked so that pairs (x, y) and (y, x) don't get counted twice
                 System.out.println(x + "," + y);
                 count++;
             }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 9, 10, 20};
        int sum = maxPairSum(a);
        List<Integer> list = getPerfectSquares(sum);
        Set<Integer>   set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        int count = 0;
        for (int x : a) {
            count += countPairs(x, list, set);
        }
        System.out.println("Count of Perfect Squares : " + count);
    }
}
