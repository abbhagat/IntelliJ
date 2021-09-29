package cisco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairsWithPerfectSquareSum {

    private static int a[] = {2, 3, 6, 9, 10, 20};

    public static List<Integer> getPerfectSquares(int sum) {
        List<Integer> perfectSquares = new ArrayList<>();
        int n = 1;
        for (int i = 1; n < sum; ) {   // while current perfect square is less than or equal to n
            perfectSquares.add(n);
            n = (int) Math.pow(++i, 2);
        }
        return perfectSquares;
    }

    // Function to print the sum of maximum two elements from the array
    public static int maxPairSum() {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int x : a) {
            if (max < x) {
                secondMax = max;
                max = x;
            } else if (secondMax< x) {
                secondMax = x;
            }
        }
        return (max + secondMax);
    }

    // Function to return the count of numbers that when added with n give a perfect square
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
        int sum = maxPairSum();                                  // Sum of the maximum two elements from the array
        List<Integer> perfectSquares = getPerfectSquares(sum);  // List of perfect squares upto max
        Set<Integer> set = new HashSet<>();                    // Contains all the array elements
        for (int x : a) {
            set.add(x);
        }
        int count = 0;
        for (int x : a) {
            count += countPairsWith(x, perfectSquares, set);  // Add count of the elements that when added with a[i] give a perfect square
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPairs());
    }
}
