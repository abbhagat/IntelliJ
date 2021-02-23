package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountPairsWithPerfectSquareSum {

    private static int a[] = {2, 3, 6, 9, 10, 20};

    public static List<Integer> getPerfectSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        int current = 1, i = 1;
        while (current <= n) {     // while current perfect square is less than or equal to n
            perfectSquares.add(current);
            current = (int) Math.pow(++i, 2);
        }
        return perfectSquares;
    }

    // Function to print the sum of maximum two elements from the array
    public static int maxPairSum() {
        int max = a[0], secondMax = a[0];
        for (int x : a) {
            max = max < x ? x : max;
            secondMax = secondMax > x ? x : secondMax;
        }
        for (int x : a) {
            if (x < max && x >= secondMax) {
                secondMax = x;
            }
        }
        return (max + secondMax);
    }

    // Function to return the count of numbers that when added with n give a perfect square
    public static int countPairsWith(int n, List<Integer> perfectSquares, Set<Integer> set) {
        int count = 0;
        for (int i = 0; i < perfectSquares.size(); i++) {
            int temp = perfectSquares.get(i) - n;
            if (temp > n && set.contains(temp)) {  // temp > n is checked so that pairs (x, y) and (y, x) don't get counted twice
                System.out.println(n + "," + temp);
                count++;
            }
        }
        return count;
    }

    // Function to count the pairs whose sum is a perfect square
    public static int countPairs() {
        int max = maxPairSum();   // Sum of the maximum two elements from the array
        List<Integer> perfectSquares = getPerfectSquares(max);  // List of perfect squares upto max
        Set<Integer> set = new HashSet<>();  // Contains all the array elements
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count += countPairsWith(a[i], perfectSquares, set);  // Add count of the elements that when added with a[i] give a perfect square
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPairs());
    }
}
