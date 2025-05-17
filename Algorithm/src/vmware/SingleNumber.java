package vmware;

// Given an array of integers, every element appears twice except for one which appears exactly once.
// Find that number.

import java.util.HashMap;
import java.util.Map;

// Time Complexity O(n)
public class SingleNumber {

    private static void singleNumber(int[] a) {
        int n = 0;
        for (int x : a) {
            n ^= x;
        }
        System.out.println(n);
    }

    private static void singleNumberSolnWithMap(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        map.forEach((k, v) -> {
            if (v == 1) {
                System.out.println(k);
            }
        });
    }

    public static void main(String[] args) {
        int[] a  = {2, 2, 1};
        singleNumber(a);
        singleNumberSolnWithMap(a);
        int[] b = {4, 1, 2, 1, 2};
        singleNumber(b);
        singleNumberSolnWithMap(b);
    }
}
