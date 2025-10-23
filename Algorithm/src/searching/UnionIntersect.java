package searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionIntersect {

  private static void findUnionIntersection(int[] a, int[] b) {
    Set<Integer> set = new HashSet<>();
    Arrays.stream(a).forEach(set::add);
    System.out.println("Intersection");
    Arrays.stream(b).forEach(n -> {
      if (!set.add(n)) {
        System.out.print(n + " ");
      }
    });
    System.out.println("\nUnion");
    System.out.print(set);
  }

  public static void main(String[] args) {
    int[] a = {12, 15, 30, 35, 46, 55, 60, 72, 89, 92, 100};
    int[] b = {12, 15, 300, 350, 46, 55, 60, 72, 89, 92, 100};
    findUnionIntersection(a, b);
  }
}
