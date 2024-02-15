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

    public static boolean isIsomorphicPattern(String s1, String s2) {
        String[] word = s2.split(" ");
        if (s1.length() == word.length) {
            Map<Character, String> map = new HashMap<>();
            char[] c = s1.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (map.containsKey(c[i]) && !map.get(c[i]).equals(word[i])) {
                    return false;
                }
                map.put(c[i], word[i]);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicPattern("abaa", "dog cat dog dog"));
        System.out.println(isIsomorphicPattern("abaa", "dog cat cat dog"));
    }
}
