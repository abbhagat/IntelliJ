package strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    private static List<String> permute(char[] c, int start, int end, List<String> list) {
        if (start == end) {
            String s = "";
            for (char x : c) {
                s += x;
            }
            list.add(s);
        } else {
            for (int i = start; i <= end; i++) {
                swap(c, i, start);
                permute(c, start + 1, end, list);
                swap(c, i, start);
            }
        }
        return list;
    }

    public static void swap(char[] c, int i, int j) {
        char x = c[i];
        c[i] = c[j];
        c[j] = x;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        permute("ABC".toCharArray(), 0, "ABC".length() - 1, list).forEach(System.out::println);
    }


}
