package leetcode;

import java.util.LinkedList;

public class PrintAllSubsetOfString {

    private static void findSubset(char[] a, int index, LinkedList<String> list) {
        if (index == a.length) {
            System.out.println(list);
        } else {
            findSubset(a, index + 1, list);
            list.add("" + a[index]);
            findSubset(a, index + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        findSubset("abc".toCharArray(), 0, new LinkedList<>());
    }
}
