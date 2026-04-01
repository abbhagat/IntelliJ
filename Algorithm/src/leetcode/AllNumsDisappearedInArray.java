package leetcode;

import java.util.*;

/*
You’re given an array: Size = n Values range from 1 to n
Some numbers are missing, and some may appear twice.
You need to return all numbers in the range [1, n] that do not appear in the array.
*/

// Time  Complexity	: O(n)
// Space Complexity	: O(1)
public class AllNumsDisappearedInArray {

  private static void findDisappearedNumbers(int[] a) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      int j = Math.abs(a[i]) - 1;
      if (a[j] > 0) {
        a[j] = -a[j];          // Mark indices as visited
      }
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] > 0) {
        list.add(i + 1);     // Find missing numbers
      }
    }
    System.out.println(list);
  }

  public static void main(String[] args) {
    findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    System.out.println();
    findDisappearedNumbers(new int[]{1, 1});
  }
}
