package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EfficientJanitor {

  private static int efficientJanitor(List<Float> a) {
    Collections.sort(a);
    int i = 0, j = a.size() - 1, trips = 0;
    while (i < j) {
      if (a.get(i) + a.get(j) <= 3.0f) {
        i++;
      }
      j--;
      trips++;
    }
    trips += (i == j && a.get(i) <= 3.0f) ? 1 : 0;
    return trips;
  }

  public static void main(String[] args) {
    System.out.println(efficientJanitor(new ArrayList<>(List.of(1.01f, 1.99f, 2.5f, 1.5f, 1.01f))));
    System.out.println(efficientJanitor(new ArrayList<>(List.of(1.01f))));
  }
}
