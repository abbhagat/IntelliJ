package adobe;

import java.util.List;

/**
 Given a string s and a dictionary of strings wordDict,
 return true if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note that the same word in the dictionary may be reused multiple times in the segmentation.

 Example 1:

 Input: s = "leetcode", wordDict = ["leet","code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:

 Input: s = "applepenapple", wordDict = ["apple","pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 Output: false
 */
public class WordBreak {

    public static boolean wordBreak(String str, List<String> list) {
        int n = str.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String s = str.substring(j, i);
                if (dp[j] && list.contains(s)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println( wordBreak("catsanddog",     List.of("cat","cats","and","sand","dog")));
        System.out.println( wordBreak("catsandog",      List.of("cats","dog","sand","and","cat")));
        System.out.println( wordBreak("applepenapple",  List.of("apple","pen")));
        System.out.println( wordBreak("leetcode",       List.of("leet","code")));
    }
}
