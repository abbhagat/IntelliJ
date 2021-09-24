package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsetOfString {

    private static void findSubset(char[] a, int index, List<String> list) {
        if (index == a.length) {
            System.out.println(list);
        } else {
            findSubset(a, index + 1, list);
            list.add("" + a[index]);
            findSubset(a, index + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        findSubset("abc".toCharArray(), 0, new ArrayList<>());
    }
}
