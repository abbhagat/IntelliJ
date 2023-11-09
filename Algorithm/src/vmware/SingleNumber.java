package vmware;

// Given an array of integers, every element appears twice except for one which appears exactly once. Find that number.

import java.util.HashMap;
import java.util.Map;

// Time Complexity O(n)
public class SingleNumber {

    private static void singleNumber(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }
        System.out.println(x);
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
        singleNumber(new int[]{2, 2, 1});
        singleNumberSolnWithMap(new int[]{2, 2, 1});
        singleNumber(new int[]{4, 1, 2, 1, 2});
        singleNumberSolnWithMap(new int[]{4, 1, 2, 1, 2});
    }
}
