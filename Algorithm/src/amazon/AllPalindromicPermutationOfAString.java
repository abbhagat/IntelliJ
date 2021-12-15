package amazon;

//Time Complexity: O(N*2^N)
//Auxiliary Space: O(N^2), where N is the length of the String

import java.util.LinkedList;

public class AllPalindromicPermutationOfAString {

    private static boolean isPalindrome(String str, int low, int high) {
        while (low <= high) {
            if (str.charAt(low++) != str.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    private static void findAllPalindromicPermutation(int index, String str, LinkedList<String> list) {
        if (index == str.length()) {
            System.out.println(list);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                list.add(str.substring(index, i + 1));
                findAllPalindromicPermutation(i + 1, str, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        findAllPalindromicPermutation(0,"madam", new LinkedList<>());
        findAllPalindromicPermutation(0,"nitin", new LinkedList<>());
        findAllPalindromicPermutation(0,"geeks", new LinkedList<>());
    }
}
