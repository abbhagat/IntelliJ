package arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayListDelete3rdElement {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        list.forEach(System.out::println);
        int pos = 3;
        pos--;
        for (int i = pos; i < list.size(); i += pos) {
            list.remove(i);
        }
        list.forEach(System.out::println);
    }
}
