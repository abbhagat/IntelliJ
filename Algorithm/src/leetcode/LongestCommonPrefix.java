package leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        return longestCommonPrefix(list, 0, list.size() - 1);
    }

    private static String longestCommonPrefix(List<String> list, int low, int high) {
        if (low == high) {
            return list.get(0);
        }
        int mid = (low + high) / 2;
        String lcpLeft  = longestCommonPrefix(list, low, mid);
        String lcpRight = longestCommonPrefix(list, mid + 1, high);
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
        System.out.println(longestCommonPrefix(Arrays.asList("flower", "flow", "flight")));
        System.out.println(longestCommonPrefix(Arrays.asList("flower")));
    }
}
