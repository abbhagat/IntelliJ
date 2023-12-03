package adobe;

import java.util.Arrays;

public class LongestSubstringWithKDistinctCharacters {

    private static void kUniques(String s, int k) {
        int[] temp = new int[128];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (temp[c] == 0) {
                count++;
            }
            temp[c]++;
        }
        if (count < k) {
            System.out.print("Not enough unique characters");
            return;
        }
        int start = 0, end = 0, max_window_start = 0, max_window_size = 1;
        Arrays.fill(temp, 0);
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
    }
}
