package leetcode;

import java.util.ArrayList;
import java.util.List;

// Time  Complexity: O(2^n)
// Space Complexity: O(2^n)
public class UniqueBinaryString {

    private static void findUniqueBinaryString(String s, int n, List<String> list) {
        if (n == 0) {
            list.add(s);
            return;
        }
        findUniqueBinaryString(s + "0", n - 1, list);
        findUniqueBinaryString(s + "1", n - 1, list);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        findUniqueBinaryString("", 2, list);
        System.out.println(list);
    }
}
