package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// "^0+(?!$)" Remove leading zeros but keep one zero if the entire string is zeros
// 0+ → One or more zeros
// (?!$) → Negative lookahead

public class FormSmallestNumberFromGivenArray {

  public static String smallestNumber(int[] a) {
    List<String> list = new ArrayList<>();
    Arrays.stream(a).forEach(x -> list.add(String.valueOf(x)));
    list.sort((x, y) -> (x + y).compareTo(y + x));
    String s = String.join("", list);
    s = s.replaceFirst("^0+(?!$)", "");
    return s;
  }

  public static void main(String[] args) {
    System.out.println(smallestNumber(new int[]{0, 0, 0, 0, 0}));
    System.out.println(smallestNumber(new int[]{3, 30, 34, 5, 9}));
    System.out.println(smallestNumber(new int[]{0, 1, 2, 3, 4}));
    System.out.println(smallestNumber(new int[]{4, 5, 0, 8}));
    System.out.println(smallestNumber(new int[]{542, 60}));
  }
}
