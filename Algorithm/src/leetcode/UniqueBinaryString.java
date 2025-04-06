package leetcode;

import java.util.HashSet;
import java.util.Set;

// Time  Complexity: O(2^n)
// Space Complexity: O(2^n)
public class UniqueBinaryString {

    private static void findUniqueBinaryString(String s, int n, Set<String> set) {
        if (n == 0) {
            set.add(s);
            return;
        }
        findUniqueBinaryString(s + "0", n - 1, set);
        findUniqueBinaryString(s + "1", n - 1, set);
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        findUniqueBinaryString("",2, set);
        System.out.println(set);
    }
}
