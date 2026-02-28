package vmware;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * Input: s = "cbaebabacd", p = "abc" Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Input: s = "abab", p = "ab" Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class FindAllAnagramsInAString {

  private static List<Integer> findAnagrams(char[] s, char[] p) {
    List<Integer> list = new ArrayList<>();
    if (s.length < p.length) {
      return list;
    }
    int[] sData = new int[128];
    int[] pData = new int[128];
    for (char c : p) {  // small string length first
      sData[c]++;
      pData[c]++;
    }
    if (matches(sData, pData)) {
      list.add(0);
    }
    for (int i = 0, j = p.length; j < s.length; i++, j++) {  // traverse the larger string "s" from index = p to s.length
      sData[s[j]]++;
      sData[s[i]]--;
      if (matches(sData, pData)) {
        list.add(i + 1);
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
    System.out.println(findAnagrams("abab".toCharArray(), "ab".toCharArray()));
    System.out.println(findAnagrams("abab".toCharArray(), "gfh".toCharArray()));
    System.out.println(findAnagrams("ab".toCharArray(), "gfh".toCharArray()));
    System.out.println(findAnagrams("cbaebabacd".toCharArray(), "abc".toCharArray()));
    System.out.println(findAnagrams("retract".toCharArray(), "cat".toCharArray()));
  }
}
