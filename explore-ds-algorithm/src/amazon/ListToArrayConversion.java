package amazon;

import java.util.Arrays;
import java.util.List;

public class ListToArrayConversion {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("A", "B", "C");
    String[] str = list.toArray(new String[0]); // list.toArray(new String[list.size()]);
    System.out.println(Arrays.toString(str));

    List<List<String>> listOfList = Arrays.asList(
        Arrays.asList("A", "B"),
        Arrays.asList("C", "D"),
        Arrays.asList("E", "F")
    );

    String[][] strArray = listOfList.stream()
        .map(innerList -> innerList.toArray(new String[0]))
        .toArray(String[][]::new);

    List<List<Integer>> intListOfList = Arrays.asList(
        Arrays.asList(1, 2),
        Arrays.asList(3, 4),
        Arrays.asList(5, 6)
    );

    int[][] intArray = intListOfList.stream()
        .map(innerList -> innerList.stream()
            .mapToInt(Integer::intValue)
            .toArray())
        .toArray(int[][]::new);

  }
}
