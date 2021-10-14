package leetcode;

public class LongestCommonSuffix {

    private static String longestCommonSuffix(String[] str, int low, int high) {
        if (low == high) {
            return str[low];
        }
        int mid = (low + high) / 2;
        String left  = longestCommonSuffix(str, low, mid);
        String right = longestCommonSuffix(str, mid + 1, high);
        return longestCommonSuffix(left, right);
    }

    private static String longestCommonSuffix(String left, String right) {
        left  = new StringBuilder( left).reverse().toString();
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
        System.out.println(longestCommonSuffix(new String[]{"ABCDEBUILD", "QOUCTBUILD"}, 0, 1));
        System.out.println(longestCommonSuffix(new String[]{"ABCDEBUILD", "ABCDEBUILD"}, 0, 1));
    }
}
