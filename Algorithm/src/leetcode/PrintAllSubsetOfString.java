package leetcode;

import java.util.LinkedList;

// Time Complexity : O(n * (2 ^ n)). For every index i two recursive cases originate, So Time Complexity is O(2^n)
// Space Complexity: O(n)
public class PrintAllSubsetOfString {

    private static void findSubSet(char[] a, int index, LinkedList<Character> list) {
        if (index == a.length) {
            if (!list.isEmpty()) {
                System.out.println(list);
            }
            return;
        }
        list.add(a[index]);
        findSubSet(a, index + 1, list);
        list.removeLast();
        findSubSet(a, index + 1, list);
    }

    public static void main(String[] args) {
        findSubSet("abc".toCharArray(), 0, new LinkedList<>());
    }
}
