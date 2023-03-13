package amazon;

import java.util.Arrays;
import java.util.List;

public class ListToArrayConversion {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        String[] str = new String[list.size()];
        list.toArray(str);
        int i = 0;
        do {
            System.out.println(str[i]);
            i++;
        } while (i < str.length);
    }
}
