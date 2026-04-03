package geeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionIntersectionOfUnSortedArray {

  private static void unionIntersection(int[] a, int[] b) {
    Set<Integer> set = new HashSet<>();
    Arrays.stream(a).forEach(set::add);
    System.out.print("Intersection : ");
    Arrays.stream(b).forEach(x -> {
      if (!set.add(x)) {
        System.out.print(x + " ");
      }
    });
    System.out.println("\nUnion        : " + set);
  }

  public static void main(String[] args) {
    int[] a = {12, 55, 60, 72, 89, 35, 35, 46, 12, 46, 100};
    int[] b = {12, 15, 30, 23, 10, 60, 35, 89, 92, 100, 10, 23, 45, 60};
    unionIntersection(a, b);
  }
}
