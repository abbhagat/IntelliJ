package leetcode;

import java.util.LinkedList;

// Time Complexity: O(n * (2 ^ n)). For every index i two recursive cases originate, So Time Complexity is O(2^n)
// Space Complexity: O(n).

public class PrintAllSubsetOfString {

    private static void findSubSet(char[] a, int index, LinkedList<String> list) {
        if (index == a.length) {
            System.out.println(list);
        } else {
            list.add(String.valueOf(a[index]));
            findSubSet(a, index + 1, list);
            list.removeLast();
            findSubSet(a, index + 1, list);
        }
    }

    public static void main(String[] args) {
        findSubSet("abc".toCharArray(), 0, new LinkedList<>());
    }
}
