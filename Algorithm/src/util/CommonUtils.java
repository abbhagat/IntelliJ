package util;

public class CommonUtils {

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i]  = a[j];
        a[j]  = t;
    }

    public static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i]   = a[j];
        a[j]   = t;
    }

    public static void swap(String[] a, int i, int j) {
        String t = a[i];
        a[i]     = a[j];
        a[j]     = t;
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int j = s.length() - 1;
        for (int i = 0; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static int minimum(int x, int y, int z) {
        return Integer.min(x, Integer.min(y, z));
    }
}
