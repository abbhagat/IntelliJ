package adobe;

import static java.lang.Integer.max;

// Time  Complexity : O(n log n)
// Space Complexity : O(log n) The recursion stack depth is proportional to the number of divisions,
// which is at most log n in the worst case
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    private static int longestSubString(String s, int start, int end, int k) {
        int[] temp = new int[128];
        for (int i = start; i < end; i++) {
            temp[s.charAt(i)]++;
        }
        for (int i = start; i < end; i++) {
            if (temp[s.charAt(i)] < k) {
                return max(longestSubString(s, start, i, k), longestSubString(s, i + 1, end, k));
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(longestSubString("ababbc",0, "ababbc".length(),2));
        System.out.println(longestSubString("aaabb", 0, "aaabb".length() ,3));
        System.out.println(longestSubString("aaabbb",0, "aaabbb".length(),3));
    }
}
