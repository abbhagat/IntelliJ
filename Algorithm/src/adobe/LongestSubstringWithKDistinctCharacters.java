package adobe;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    private static void kUniques(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (map.keySet().size() < k) {
            System.out.print("Not enough unique characters");
            return;
        }
        int start = 0, end = 0, max_window_start = 0, max_window_size = 1;
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
                max_window_start = start;
            }
        }
        System.out.println("Max substring is : " + s.substring(max_window_start, max_window_start + max_window_size) + " with length " + max_window_size);
    }

    private static boolean isValid(int[] temp, int k) {
        int count = 0;
        for (int i = 0; i < 128; i++) {
            if (temp[i] > 0) {
                count++;
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        kUniques("aabacbebebe", 3);
        kUniques("aabbcc", 1);
        kUniques("aabbcc", 2);
        kUniques("aabbcc", 3);
    }
}
