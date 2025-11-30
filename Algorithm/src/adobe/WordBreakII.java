package adobe;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences in any order.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation
 * Example 1:
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3: Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 */

// Time  Complexity: O(2^n)
// Space Complexity: O(m + n)
public class WordBreakII {

  public static List<String> wordBreak(String str, List<String> wordDict) {
    List<String> list = new ArrayList<>();
    wordBreak(0, str, new StringBuilder(), wordDict, list);
    return list;
  }

  private static void wordBreak(int index, String str, StringBuilder sb, List<String> wordDict, List<String> list) {
    if (index == str.length()) {
      list.add(sb.toString().trim());
      return;
    }
    for (int i = index + 1; i <= str.length(); i++) {
      String s = str.substring(index, i);
      if (wordDict.contains(s)) {
        int len = sb.length();
        sb.append(s).append(" ");
        wordBreak(i, str, sb, wordDict, list);
        sb.setLength(len);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println((wordBreak("catsanddog",        List.of("cat", "cats", "and", "sand", "dog"))));
    System.out.println((wordBreak("catsandog",         List.of("cats","dog","sand","and","cat"))));
    System.out.println((wordBreak("pineapplepenapple", List.of("apple","pen","applepen","pine","pineapple"))));
  }
}
