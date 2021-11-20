package amazon;

import java.util.Arrays;
import java.util.List;

public class ListToArrayConversion {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        String[] strs = new String[list.size()];
        strs = list.toArray(strs);
        int i = 0;
        do {
            System.out.println(strs[i]);
            i++;
        } while (i < strs.length);
    }
}