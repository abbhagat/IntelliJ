package adobe;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 * <p>
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 */

public class WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        dfs(s, set, res, new StringBuilder(), 0);
        return res;
    }

    public static void dfs(String s, Set<String> set, List<String> res, StringBuilder sb, int index) {
        if (index == s.length()) {
            res.add(sb.toString().trim());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (set.contains(sub)) {
                sb.append(sub).append(" ");
                dfs(s, set, res, sb, i + 1);
                sb.delete(sb.length() - sub.length() - 1, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")).forEach(System.out::println);
    }
}
