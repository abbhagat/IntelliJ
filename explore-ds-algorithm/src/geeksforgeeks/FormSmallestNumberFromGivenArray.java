package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// x = "542", y = "60" x + y = "54260" and x + y = "54260" => "54260" > "60542" So "542" should come before "60"
public class FormSmallestNumberFromGivenArray {

  public static long smallestNumber(int[] a) {
    List<String> list = new ArrayList<>();
    Arrays.stream(a).forEach(x -> list.add(String.valueOf(x)));
    list.sort((x, y) -> (x + y).compareTo(y + x));
    String s = String.join("", list);
    return Long.parseLong(s);
  }

  public static void main(String[] args) {
    System.out.println(smallestNumber(new int[]{0, 0, 0, 0, 0}));
    System.out.println(smallestNumber(new int[]{3, 30, 34, 5, 9}));
    System.out.println(smallestNumber(new int[]{0, 1, 2, 3, 4}));
    System.out.println(smallestNumber(new int[]{4, 5, 0, 8}));
    System.out.println(smallestNumber(new int[]{542, 60}));
  }
}
