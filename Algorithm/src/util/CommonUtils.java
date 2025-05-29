package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.max;

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

    public static int maximum(int x, int y, int z) {
        return Integer.max(x, Integer.max(y, z));
    }

    public static void printArray(int[] a) {
        Arrays.stream(a).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void printArray(char[] a) {
        IntStream.range(0, a.length)
                 .mapToObj(i -> a[i])
                 .forEach(s -> System.out.print(s + " "));
        // Arrays.stream(String.valueOf(a).split("")).forEach(c -> System.out.print(c + " "));
        System.out.println();
    }

    public static void printArray(String[] str) {
        Arrays.stream(str).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    public static void printMatrix(int[][] M) {
        for (int[] x : M) {
            Arrays.stream(x).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(char[][] M) {
        for (char[] c : M) {
            printArray(c);
        }
        System.out.println();
    }

    public static void printArray(List<int[]> M) {
        for (int[] x : M) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static int gcd(int x, int y) {
        int gcd = 0;
        for (int i = 1; i <= max(x,y); i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
