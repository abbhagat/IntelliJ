package amazon;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static final Map<Character, Integer> roman = new HashMap<>() {
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
        int sum = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != n && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                sum += roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i));
                i++;
            } else {
                sum += roman.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ;
        System.out.print(romanToInt("IX"));
        System.out.print(romanToInt("MCMIV"));
    }
}