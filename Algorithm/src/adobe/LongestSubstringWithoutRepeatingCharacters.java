package adobe;

import java.util.*;

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
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                set.add(s.substring(i, j));
//            }
//        }
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
        int index = 0, max = result.get(0).length();
        for (int i = 1; i < result.size(); i++) {
            if (max < result.get(i).length()) {
                max = result.get(i).length();
                index = i;
            }
        }
        System.out.println(result.get(index));
    }

    // Time  Complexity : O(n)
    // Space Complexity : O(128)
    private static int lengthOfLongestSubstring(char[] c) {
        int j = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int[] temp = new int[128];
        for (int i = 0; i < c.length; i++) {
            j = max(j, temp[c[i]]);
            max = max(max, i - j + 1);
            temp[c[i]] = i + 1;
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            max = max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb".toCharArray())      + "\t" + lengthOfLongestSubstring("abcabcbb"));  // abc
        System.out.println(lengthOfLongestSubstring("aabacbebebe".toCharArray())   + "\t" + lengthOfLongestSubstring("aabacbebebe"));  // acbe
        System.out.println(lengthOfLongestSubstring("bbbbb".toCharArray())         + "\t" + lengthOfLongestSubstring("bbbbb"));  // b
        System.out.println(lengthOfLongestSubstring("pwwkew".toCharArray())        + "\t" + lengthOfLongestSubstring("pwwkew")); // wke, kew
        System.out.println(lengthOfLongestSubstring("geeksforgeeks".toCharArray()) + "\t" + lengthOfLongestSubstring("geeksforgeeks"));

        findFirstLongestSubstringWithoutRepeatingChar("kyckyckk");
    }
}
