package leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestCommonSuffix {

    private static String longestCommonSuffix(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        return longestCommonSuffix(list, 0, list.size() - 1);
    }

    private static String longestCommonSuffix(List<String> list, int low, int high) {
        if (low == high) {
            return list.get(low);
        } else {
            int mid = (low + high) / 2;
            String lcsLeft  = longestCommonSuffix(list, low, mid);
            String lcsRight = longestCommonSuffix(list, mid + 1, high);
            return longestCommonSuffix(lcsLeft, lcsRight);
        }
    }

    private static String longestCommonSuffix(String left, String right) {
        left  = new StringBuilder(left).reverse().toString();
        right = new StringBuilder(right).reverse().toString();
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return new StringBuilder(left.substring(0, i)).reverse().toString();
            }
        }
        return new StringBuilder(left.substring(0, min)).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSuffix(Arrays.asList("ABCDEBUILD", "OUCTBUILD")));
        System.out.println(longestCommonSuffix(Arrays.asList("ABCDEBUILD", "ABCDEBUILD")));
    }
}
