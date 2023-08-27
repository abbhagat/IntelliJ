package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueBinaryString {

    private static void findAllBinaryPermutation(String s, int itr, Set<String> set) {
        if (itr == 0) {
            set.add(s);
            return;
        }
        findAllBinaryPermutation(s + "0", itr - 1, set);
        findAllBinaryPermutation(s + "1", itr - 1, set);
    }

    public static String findUniqueBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        findAllBinaryPermutation("", nums.length, set);
        System.out.println(set);
        return (String) set.toArray()[0];
    }

    public static void main(String[] args) {
        System.out.println(findUniqueBinaryString(new String[]{"01", "10"}));
    }
}
