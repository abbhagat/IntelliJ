package java8.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimitiveToListDemo {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
    list.add(11);
    list.forEach(System.out::println);
  }

}
