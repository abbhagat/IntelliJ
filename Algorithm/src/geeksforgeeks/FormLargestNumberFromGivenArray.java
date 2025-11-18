package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class FormLargestNumberFromGivenArray {

  public static String largestNumber(int[] a) {
    List<String> list = new ArrayList<>();
    int countZero = 0;
    for (int x : a) {
      list.add(String.valueOf(x));
      if (x == 0) {
        countZero++;
      }
    }
    if (countZero == a.length) {
      return "0";
    }
    list.sort((x, y) -> (y + x).compareTo(x + y));
    StringBuilder result = new StringBuilder();
    list.forEach(result::append);
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    System.out.println(largestNumber(new int[]{542, 60}));
    System.out.println(largestNumber(new int[]{98, 9}));
  }
}
