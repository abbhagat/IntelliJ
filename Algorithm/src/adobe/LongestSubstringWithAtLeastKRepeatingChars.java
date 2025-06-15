package adobe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n log n)
// Space Complexity : O(log n)
public class LongestSubstringWithAtLeastKRepeatingChars {

    @Getter
    @Setter
    @AllArgsConstructor
    static class Index {
        int start;
        int end;
    }

    private static int longestSubString(String s, int start, int end, int k, Index index) {
        Map<Character, Integer> map = new HashMap<>();
        s.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
        for (int i = start; i < end; i++) {
            if (map.get(s.charAt(i)) < k) {
                int max;
                int left  = longestSubString(s, start, i, k, index);
                int right = longestSubString(s, i + 1, end, k, index);
                if (left >= right) {
                    max = left;
                    index.setStart(start);
                    index.setEnd(i);
                } else {
                    max = right;
                    index.setStart(i + 1);
                    index.setEnd(end);
                }
                return max;
            }
        }
        index.start = start;
        index.end   = end;
        return end - start;
    }

    public static void main(String[] args) {
        Index index = new Index(0, 0);
        int max = longestSubString("ababbc",0, "ababbc".length(),2, index);
        System.out.println("ababbc".substring(index.start, index.end) + "\t" + max);

        index = new Index(0, 0);
        max = longestSubString("aaabb", 0, "aaabb".length() ,3, index);
        System.out.println("aaabb".substring(index.start, index.end) + "\t" + max);

        index = new Index(0, 0);
        max = longestSubString("aaabbb",0, "aaabbb".length(),3, index);
        System.out.println("aaabbb".substring(index.start, index.end) + "\t" + max);
    }
}
