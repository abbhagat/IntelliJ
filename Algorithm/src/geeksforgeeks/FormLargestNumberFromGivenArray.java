package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// "^0+(?!$)" Remove leading zeros but keep one zero if the entire string is zeros
// 0+ → One or more zeros
// (?!$) → Negative lookahead “Do NOT match if what follows at the end of the string” In simple words: Do not remove zeros if they are the entire string

public class FormLargestNumberFromGivenArray {

  public static String largestNumber(int[] a) {
    List<String> list = new ArrayList<>();
    Arrays.stream(a).forEach(x -> list.add(String.valueOf(x)));
    list.sort((x, y) -> (y + x).compareTo(x + y));
    String s = String.join("", list);
    s = s.replaceFirst("^0+(?!$)", "");
    return s;
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(new int[]{0, 0, 0, 0, 0}));
    System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    System.out.println(largestNumber(new int[]{0, 1, 2, 3, 4}));
    System.out.println(largestNumber(new int[]{4, 5, 0, 8}));
    System.out.println(largestNumber(new int[]{542, 60}));
  }
}
