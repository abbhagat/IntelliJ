package cisco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class FindAllAnagramsInAString {

    private static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }
        int[] c1Data = new int[26];
        for (char x : p.toCharArray()) {
            c1Data[x - 'a']++;
        }
        int[] c2Data = new int[26];
        List<Integer> list = new ArrayList<>();
        int i;
        for (i = 0; i < p.length(); i++) {
            c2Data[s.charAt(i) - 'a']++;
        }
        if (matches(c2Data, c1Data)) {
            list.add(0);
        }
        while (i < s.length()) {
            c2Data[s.charAt(i - p.length()) - 'a']--;
            c2Data[s.charAt(i) - 'a']++;
            if (matches(c2Data, c1Data)) {
                list.add(i - p.length() + 1);
            }
            i++;
        }
        return list;
    }

    private static boolean matches(int[] c1Data, int[] c2Data) {
        for (int i = 0; i < 26; i++) {
            if (c1Data[i] != c2Data[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
