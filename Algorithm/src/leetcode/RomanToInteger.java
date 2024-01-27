package leetcode;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity  O(n)
// Space Complexity  O(n)

public class RomanToInteger {

    private static final Map<Character, Integer> map = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    private static int romanToInt(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = map.get(s.charAt(i));
            int y = i + 1 < s.length() ? map.get(s.charAt(i + 1)) : 0;
            if (x < y) {
                n += y - x;
                i++;
            } else {
                n += x;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("MCMIV"));
    }
}
