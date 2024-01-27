package adobe;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.max;

public class LongestSubstringWithKDistinctCharacters {

    private static int lengthOfLongestSubstringKDistinct(char[] c, int k) {
        int max = 0, distinct = 0, j = 0;
        int[] temp = new int[128];
        for (int i = 0; i < c.length; i++) {
            if (++temp[c[i]] == 1) {
                distinct++;
            }
            while (distinct == k + 1) {
                if (--temp[c[j++]] == 0) {
                    distinct--;
                }
            }
            max = max(max, i - j + 1);
        }
        return max;
    }

    private static void kUniques(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        if (set.size() < k) {
            System.out.print("Not enough unique characters");
            return;
        }
        int start = 0, end = 0, startIndex = 0, max_window_size = 1;
        int[] temp = new int[128];
        temp[s.charAt(0)]++;
        for (int i = 1; i < s.length(); i++) {
            temp[s.charAt(i)]++;
            end++;
            while (!isValid(temp, k)) {
                temp[s.charAt(start)]--;
                start++;
            }
            if (end - start + 1 > max_window_size) {
                max_window_size = end - start + 1;
                startIndex = start;
            }
        }
        System.out.println("Max substring is : " + s.substring(startIndex, startIndex + max_window_size) + " with length " + max_window_size);
    }

    private static boolean isValid(int[] temp, int k) {
        int count = 0;
        for (int x : temp) {
            if (x > 0) {
                count++;
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        kUniques("aabacbebebe", 3);
        System.out.println(lengthOfLongestSubstringKDistinct("aabacbebebe".toCharArray(), 3));
        kUniques("aabbcc", 1);
        kUniques("aabbcc", 2);
        kUniques("aabbcc", 3);
    }
}
