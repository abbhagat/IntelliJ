package cisco;

// Given an array of integers, every element appears twice except for one which appears exactly once. Find that number.

import java.util.HashMap;
import java.util.Map;

// Time Complexity O(n)
public class SingleNumber {

    private static void singleNumber(int[] a) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : a) {
                if ((n >> i & 1) == 1) {          // >> has higher priority than & and |
                    sum++;
                }
            }
            sum %= 2;
            result |= sum << i;
        }
        System.out.println(result);
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
