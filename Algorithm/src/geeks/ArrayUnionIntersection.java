package geeks;

import java.util.*;

public class ArrayUnionIntersection {

  private void unionIntersection(int[] a, int[] b) {
    Map<Integer,Integer> map = new LinkedHashMap<>();
    Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    Arrays.stream(b).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    System.out.print("Intersection : ");
    map.forEach((k,v) -> {
      if(v > 1) {
        System.out.print(k + " ");
      }
    });
    System.out.println("\nUnion        : " + map.keySet());
  }

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    int[] a = {12, 55, 60, 72, 89, 35, 35, 46, 12, 46, 100};
    int[] b = {12, 15, 30, 23, 10, 60, 35, 89, 92, 100, 10, 23, 45, 60};
    for (int x : a) {
      set.add(x);
    }
    System.out.print("Intersection : ");
    for (int x : b) {
      if (!set.add(x)) {
        System.out.print(x + " ");
      }
    }
    System.out.println("\nUnion        : " + set);
  }
}
