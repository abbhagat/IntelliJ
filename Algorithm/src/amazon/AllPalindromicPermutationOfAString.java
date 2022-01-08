package amazon;

//Time Complexity: O(N*2^N)
//Auxiliary Space: O(N^2), where N is the length of the String

import java.util.LinkedList;

public class AllPalindromicPermutationOfAString {

    private static void findAllPalindromicPermutation(int index, String str, LinkedList<String> list) {
        if (index == str.length()) {
            System.out.println(list);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            String s = str.substring(index, i + 1);
            if (s.equals(new StringBuilder(s).reverse().toString())) {
                list.add(s);
                findAllPalindromicPermutation(i + 1, str, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        findAllPalindromicPermutation(0, "madam", new LinkedList<>());
        findAllPalindromicPermutation(0, "nitin", new LinkedList<>());
        findAllPalindromicPermutation(0, "geeks", new LinkedList<>());
    }
}
