package strings;

import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false
 */
public class IsomorphicWordPattern {

    public static boolean isIsomorphicPattern(String s1, String s3) {
        String[] s2 = s3.split(" ");
        if (s1.length() == s2.length) {
            Map<Character, String> map = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                if (map.containsKey(s1.charAt(i)) && !map.get(s1.charAt(i)).equals(s2[i])) {
                    return false;
                }
                map.put(s1.charAt(i), s2[i]);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicPattern("abaa", "dog cat cat dog"));
    }
}
