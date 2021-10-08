package leetcode;

public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] str, int low, int high) {
        if (low == high) {
            return str[low];
        }
        int mid = (low + high) / 2;
        String lcpLeft  = longestCommonPrefix(str, low, mid);
        String lcpRight = longestCommonPrefix(str, mid + 1, high);
        return commonPrefix(lcpLeft, lcpRight);
    }

    private static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}, 0, 2));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow"}, 0, 1));
        System.out.println(longestCommonPrefix(new String[]{"flower"}, 0, 0));
    }
}
