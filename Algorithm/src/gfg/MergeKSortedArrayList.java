package gfg;

import java.util.ArrayList;
import java.util.List;

// Time  Complexity : O(N * log K)  N = total number of elements across all arrays K = number of sorted arrays (or lists)
// Space Complexity : O(N)
public class MergeKSortedArrayList {

  private static List<Integer> sortList(List<Integer> a, List<Integer> b) {
    List<Integer> c = new ArrayList<>();
    int i = 0, j = 0;
    while (i < a.size() && j < b.size()) {
      if (a.get(i) == b.get(j)) {
        c.add(a.get(i));
        i++;
        j++;
      } else {
        c.add(a.get(i) < b.get(j) ? a.get(i++) : b.get(j++));
      }
    }
    while (i < a.size()) {
      c.add(a.get(i++));
    }
    while (j < b.size()) {
      c.add(b.get(j++));
    }
    return c;
  }

  public static List<Integer> mergeKLists(List<List<Integer>> list) {
    if (list == null || list.size() == 0) {
      return new ArrayList<>();
    }
    return merge(list, 0, list.size() - 1);
  }

  private static List<Integer> merge(List<List<Integer>> list, int low, int high) {
    if (low == high) {
      return list.get(low);
    }
    int mid = (low + high) / 2;
    List<Integer> a = merge(list, low, mid);
    List<Integer> b = merge(list, mid + 1, high);
    return sortList(a, b);
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> a = List.of(1, 4, 7, 10);
    List<Integer> b = List.of(3, 5, 9, 12);
    List<Integer> c = List.of(2, 6, 8, 11);
    list.add(a);
    list.add(b);
    list.add(c);
    List<Integer> sorted = mergeKLists(list);
    System.out.println(sorted);
  }
}
