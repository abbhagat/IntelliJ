package leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestCommonSuffix {

    private static String longestCommonSuffix(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        String[] strs = new String[list.size()];
        strs = list.toArray(strs);
        return longestCommonSuffix(strs, 0, strs.length - 1);
    }

    private static String longestCommonSuffix(String[] strs, int low, int high) {
        if (low == high) {
            return strs[low];
        } else {
            int mid = (low + high) / 2;
            String lcsLeft = longestCommonSuffix(strs, low, mid);
            String lcsRight = longestCommonSuffix(strs, mid + 1, high);
            return longestSuffix(lcsLeft, lcsRight);
        }
    }

    private static String longestSuffix(String left, String right) {
        if (left.length() > right.length()) {
            String temp = left;
            left = right;
            right = temp;
        }
        int min = left.length() - 1;
        int j = right.length() - left.length();
        for (int i = min; i >= 0; i--) {
            if (left.charAt(i) != right.charAt(i + j)) {
                return left.substring(i + 1);
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSuffix(Arrays.asList("ABCDEBUILD", "OUCTBUILD")));
        System.out.println(longestCommonSuffix(Arrays.asList("ABCDEBUILD", "ABCDEBUILD")));
    }
}
