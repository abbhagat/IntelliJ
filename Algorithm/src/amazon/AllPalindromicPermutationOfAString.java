package amazon;

// Expected Time Complexity: O(N*2^N)
// Expected Auxiliary Space: O(N^2), where N is the length of the String

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPalindromicPermutationOfAString {

    private static boolean isPalindrome(String str, int low, int high) {
        while (low <= high) {
            if (str.charAt(low++) != str.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    private static void findAllPalindromicPermutation(int index, String str, List<List<String>> lists, LinkedList<String> deque) {
        if (index == str.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                deque.addLast(str.substring(index, i + 1));
                findAllPalindromicPermutation(i + 1, str, lists, deque);
                deque.removeLast();
            }
        }
    }

    private static void findAllPalindromicPermutation(String str) {
        List<List<String>> lists = new ArrayList<>();                      // To Store all palindromic partitions
        LinkedList<String> deque = new LinkedList<>();                    // To store current palindromic partition
        findAllPalindromicPermutation(0, str, lists, deque);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        findAllPalindromicPermutation("madam");
        findAllPalindromicPermutation("nitin");
        findAllPalindromicPermutation("geeks");
    }
}