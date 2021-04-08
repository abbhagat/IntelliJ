package amazon;

public class LongestSubsequenceString {

    private static String lengthOfLongestSubstring(char[] c) {
        String s = "" + c[0];
        String max = "";
        for (int i = 1; i < c.length; i++) {
            if (c[i] - c[i - 1] == 1) {
                s += c[i];
            } else {
                if (max.length() < s.length()) {
                    max = s;
                }
                s = "" + c[i];
            }
        }
        return max.length() < s.length() ? s : max;
    }

    public static void main(String[] args) {
        String s = lengthOfLongestSubstring("abcdedijklmnopqrstuvsfgsdgadmnopqrstuv".toCharArray());
        System.out.println(s + " " + s.length());
    }
}
