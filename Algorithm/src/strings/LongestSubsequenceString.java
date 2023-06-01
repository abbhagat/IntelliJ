package strings;

public class LongestSubsequenceString {

    private static String lengthOfLongestSubstring(char[] c) {
        String s = String.valueOf(c[0]);
        String max = "";
        for (int i = 1; i < c.length; i++) {
            int diff = c[i] - c[i - 1];
            if (diff == 1) {
                s += c[i];
            } else {
                if (diff == 0) {
                    continue;
                }
                max = max.length() < s.length() ? s : max;
                s = String.valueOf(c[i]);
            }
        }
        return max.length() < s.length() ? s : max;
    }

    public static void main(String[] args) {
        String s = lengthOfLongestSubstring("abcdedijklmnopqrstuvwxyzssssfgsdgadmnopqrstuv".toCharArray());
        System.out.println(s + " " + s.length());
    }
}
