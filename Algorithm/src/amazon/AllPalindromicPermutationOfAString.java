package amazon;

// Expected Time Complexity: O(N*2^N)
// Expected Auxiliary Space: O(N^2), where N is the length of the String

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllPalindromicPermutationOfAString {

    private static boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private static void allPalPartitionsUtil(List<List<String>> lists, Deque<String> deque, int start, int n, String input) {
        if (start >= n) {         // If 'start' has reached len
            lists.add(new ArrayList<>(deque));
            return;
        }
        // Pick all possible ending points for substrings
        for (int i = start; i < n; i++) {
            if (isPalindrome(input, start, i)) {                              // If substring str[start..i] is palindrome
                deque.addLast(input.substring(start, i + 1));                // Add the substring to result
                allPalPartitionsUtil(lists, deque, i + 1, n, input);   // Recur for remaining remaining substring
                deque.removeLast();                                        // Remove substring str[start..i] from current partition
            }
        }
    }

    private static void findAllPalindromicPermutation(String str) {
        List<List<String>> lists = new ArrayList<>();                      // To Store all palindromic partitions
        Deque<String> deque = new LinkedList<>();                         // To store current palindromic partition
        allPalPartitionsUtil(lists, deque, 0, str.length(), str);
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
