package adobe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences in any order.
Note that the same word in the dictionary may be reused multiple times in the segmentation
Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3: Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
*/

// Time  Complexity: O(2^n)
// Space Complexity: O(m + n)
public class WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        wordBreak(0, s, new StringBuilder(), new HashSet<>(wordDict), result);
        return result;
    }

    private static void wordBreak(int start, String s, StringBuilder current, Set<String> wordSet, List<String> result) {
        if (start == s.length()) {
            result.add(current.toString().trim());
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                int len = current.length();
                current.append(word).append(" ");
                wordBreak(end, s, current, wordSet, result);
                current.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        List<String> sentences = wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
        sentences.forEach(System.out::println);
    }
}
