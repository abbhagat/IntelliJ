package util;

public class Swap {

    public static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x]  = a[y];
        a[y]  =   t;
    }

    public static void swap(char[] a, int x, int y) {
        char t = a[x];
        a[x]   = a[y];
        a[y]   =   t;
    }

    public static void swap(String[] a, int x, int y) {
        String t = a[x];
        a[x]     = a[y];
        a[y]     = t;
    }
}
