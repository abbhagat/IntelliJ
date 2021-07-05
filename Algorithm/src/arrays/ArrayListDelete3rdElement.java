package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDelete3rdElement {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        list.forEach(System.out::print);
        System.out.println();
        int pos = 3;
        pos--;
        for (int i = pos; i < list.size(); i += pos) {
            list.remove(i);
        }
        list.forEach(System.out::print);
    }
}
