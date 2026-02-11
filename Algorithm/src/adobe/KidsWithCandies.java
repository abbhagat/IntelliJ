package adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {

  private static List<Boolean> kidsWithCandies(int[] candies, int extraCandy) {
    int maxCandy = Arrays.stream(candies).max().getAsInt();
    List<Boolean> list = new ArrayList<>();
    Arrays.stream(candies).forEach(candy -> list.add(candy + extraCandy >= maxCandy));
    return list;
  }

  public static void main(String[] args) {
    System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
    System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 2));
    System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 3));
  }
}
