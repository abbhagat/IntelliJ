package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// x = "542", y = "60" x + y = "54260" and y + x = "60542" => "60542" > "54260" So "60" should come before "542"

public class FormLargestNumberFromGivenArray {

  public static long largestNumber(int[] a) {
    List<String> list = new ArrayList<>();
    Arrays.stream(a).forEach(x -> list.add(String.valueOf(x)));
    list.sort((x, y) -> (y + x).compareTo(x + y));
    String s = String.join("", list);
    return Long.parseLong(s);
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(new int[]{0, 0, 0, 0, 0}));
    System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    System.out.println(largestNumber(new int[]{0, 1, 2, 3, 4}));
    System.out.println(largestNumber(new int[]{4, 5, 0, 8}));
    System.out.println(largestNumber(new int[]{542, 60}));
    System.out.println(largestNumber(new int[]{60, 542}));
  }
}
