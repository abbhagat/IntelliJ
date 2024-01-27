package adobe;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.max;

public class LongestSubstringWithoutRepeatingCharacters {

    private static void findFirstLongestSubstringWithoutRepeatingChar(String s) {
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
            set.add(s.substring(i));
            set.add(s.substring(0, i));
            set.add(s.substring(i, s.length() - 1));
        }
        List<String> result = new ArrayList<>();
        for (String str : set) {
            int[] temp = new int[128];
            for (char c : str.toCharArray()) {
                temp[c]++;
            }
            boolean flag = true;
            for (int x : temp) {
                if (x > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(str);
            }
        }
        int index = 0, length = result.get(0).length();
        for (int i = 1; i < result.size(); i++) {
            if (length < result.get(i).length()) {
                length = result.get(i).length();
                index = i;
            }
        }
        System.out.println(result.get(index));
    }

    private static void lengthOfLongestSubstring(char[] c) {
        int j = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int[] temp = new int[128];
        for (int i = 0; i < c.length; i++) {
            j = max(j, temp[c[i]]);
            max = max(max, i - j + 1);
            temp[c[i]] = i + 1;
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb".toCharArray());
        lengthOfLongestSubstring("aabacbebebe".toCharArray());
        lengthOfLongestSubstring("bbbbb".toCharArray());
        lengthOfLongestSubstring("pwwkew".toCharArray());
        lengthOfLongestSubstring("geeksforgeeks".toCharArray());
        findFirstLongestSubstringWithoutRepeatingChar("kyckyckk");
    }
}
