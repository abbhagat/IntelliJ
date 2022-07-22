package interview;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryString {

    private static void findAllBinaryPermutation(String s, int itr, List<String> list) {
        if (itr == 0) {
            list.add(s);
            return;
        }
        findAllBinaryPermutation(s + "0", itr - 1, list);
        findAllBinaryPermutation(s + "1", itr - 1, list);
    }

    public static String findUniqueBinaryString(String[] nums) {
        List<String> list = new ArrayList<>();
        findAllBinaryPermutation("", nums.length, list);
        System.out.println(list);
        for (String s : nums) {
            if (list.contains(s)) {
                list.remove(s);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(findUniqueBinaryString(new String[]{"01", "10"}));
    }
}
