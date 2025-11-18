package util;

import doublylinkedlist.Node;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.min;

public class CommonUtils {

  public static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void swap(int[][] a, int i, int j) {
    int t = a[i][j];
    a[i][j] = a[j][i];
    a[j][i] = t;
  }

  public static void swap(char[] a, int i, int j) {
    char t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void swap(String[] a, int i, int j) {
    String t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void swap(Node x, Node y) {
    int temp = x.num;
    x.num = y.num;
    y.num = temp;
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
    return min(x, min(y, z));
  }

  public static int maximum(int x, int y, int z) {
    return Integer.max(x, Integer.max(y, z));
  }

  public static void printArray(int[] a, int start, int end) {
    IntStream.range(start, end).forEach(i -> System.out.print(a[i] + " "));
    System.out.println();
  }

  public static void printArray(int[] a) {
    System.out.println(Arrays.toString(a));
  }

  public static void printArray(char[] a) {
    System.out.println(Arrays.toString(a));
  }

  public static void printArray(String[] str) {
    System.out.println(Arrays.toString(str));
  }

  public static void printMatrix(int[][] M) {
    for (int[] a : M) {
      System.out.println(Arrays.toString(a));
    }
    System.out.println();
  }

  public static void printMatrix(char[][] M) {
    for (char[] c : M) {
      System.out.println(Arrays.toString(c));
    }
    System.out.println();
  }

  public static void printArray(List<int[]> M) {
    for (int[] a : M) {
      System.out.println(Arrays.toString(a));
    }
    System.out.println();
  }

  public static int gcd(int x, int y) {
    int gcd = 0;
    for (int i = 1; i <= min(x, y); i++) {
      if (x % i == 0 && y % i == 0) {
        gcd = i;
      }
    }
    return gcd;
  }

  public static void print(int n) {
    System.out.print(n + " ");
  }

  public static void print(int x, int y) {
    System.out.print(x + " " + y);
  }
}
