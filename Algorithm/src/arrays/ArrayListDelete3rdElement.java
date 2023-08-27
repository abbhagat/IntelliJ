package arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDelete3rdElement {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int pos = 3;
        pos -= 1;
        for (int i = pos; i < list.size(); i += pos) {
            list.remove(i);
        }
        list.forEach(x -> System.out.print(x + " "));
    }
}
