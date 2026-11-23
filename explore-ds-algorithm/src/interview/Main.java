package interview;


import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    System.out.println(map.put("A", 65));
    System.out.println(map.put("A", 66));
    System.out.println(map.remove("A"));
  }

}
