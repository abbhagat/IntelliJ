package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FilteringNullFromList {

  public static void main(String[] args) {
    List<String> language = Arrays.asList("English", null, "Hindi", null);
    List<String> result = language.stream().filter(Objects::nonNull).toList();
    result.forEach(System.out::println);
  }
}
