package vmware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * <p>
 * Input: s = "cbaebabacd", p = "abc" Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Input: s = "abab", p = "ab" Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class FindAllAnagramsInAString {

  private static List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s.length() < p.length()) {
      return list;
    }
    int[] sData = new int[128];
    int[] pData = new int[128];
    for (int i = 0; i < p.length(); i++) {
      sData[s.charAt(i)]++;
      pData[p.charAt(i)]++;
    }
    for (int i = 0; i <= s.length() - p.length(); i++) {
      if (i > 0) {
        sData[s.charAt(i - 1)]--;
        sData[s.charAt(i - 1 + p.length())]++;
      }
      if (matches(sData, pData)) {
        list.add(i);
      }
    }
    return list;
  }

  private static boolean matches(int[] sData, int[] pData) {
    for (int i = 0; i < 128; i++) {
      if (sData[i] != pData[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(findAnagrams("abab", "ab"));
    System.out.println(findAnagrams("abab", "gfh"));
    System.out.println(findAnagrams("ab", "gfh"));
    System.out.println(findAnagrams("cbaebabacd", "abc"));
    System.out.println(findAnagrams("retract", "cat"));
  }
}
