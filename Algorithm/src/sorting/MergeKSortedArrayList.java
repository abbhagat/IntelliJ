package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time  Complexity : O(N * log K)  N = total number of elements across all arrays and K = number of sorted arrays (or lists)
// Space Complexity : O(N)
public class MergeKSortedArrayList {

  public static int[] mergeKLists(List<int[]> list) {
    if (list == null || list.size() == 0) {
      return new int[0];
    }
    return mergeHelper(list, 0, list.size() - 1);
  }

  private static int[] mergeHelper(List<int[]> list, int low, int high) {
    if (low == high) {
      return list.get(low);
    }
    int mid = (low + high) / 2;
    int[] a = mergeHelper(list, low, mid);
    int[] b = mergeHelper(list, mid + 1, high);
    return sortList(a, b);
  }

  private static int[] sortList(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        c[k] = a[i];
        i++;
        j++;
        k++;
      } else {
        c[k++] = a[i] < b[j] ? a[i++] : b[j++];
      }
    }
    while (i < a.length) {
      c[k++] = a[i++];
    }
    while (j < b.length) {
      c[k++] = b[j++];
    }
    return c;
  }

  public static void main(String[] args) {
    List<int[]> list = new ArrayList<>();
    int[] a = new int[]{1, 4, 7, 10};
    int[] b = new int[]{3, 5, 9, 12};
    int[] c = new int[]{2, 6, 8, 11};
    list.add(a);
    list.add(b);
    list.add(c);
    int[] sorted = mergeKLists(list);
    System.out.println(Arrays.toString(sorted));
  }
}
