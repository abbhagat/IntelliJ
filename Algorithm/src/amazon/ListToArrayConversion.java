package amazon;

import java.util.Arrays;
import java.util.List;

public class ListToArrayConversion {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("A", "B", "C");
    String[] str = list.toArray(new String[0]); // list.toArray(new String[list.size()]);
    System.out.println(Arrays.toString(str));
  }
}
