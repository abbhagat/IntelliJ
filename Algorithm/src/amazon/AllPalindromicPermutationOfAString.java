package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Time  Complexity: O(n*2^n)
// Space Complexity: O(n^2), where n is the length of the String
public class AllPalindromicPermutationOfAString {

    private static void findAllPalindromicPermutation(int index, String str, LinkedList<String> list) {
        if (index == str.length()) {
            System.out.println(list);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            String s = str.substring(index, i + 1);
            if (s.contentEquals(new StringBuilder(s).reverse())) {
                list.add(s);
                findAllPalindromicPermutation(i + 1, str, list);
                list.removeLast();
            }
        }
    }

    private static List<LinkedList<String>> findAllPalindromicPermutation(int index, String str, LinkedList<String> list, List<LinkedList<String>> lists) {
        if (index == str.length()) {
            lists.add(new LinkedList<>(list));
        }
        for (int i = index; i < str.length(); i++) {
            String s = str.substring(index, i + 1);
            if (s.contentEquals(new StringBuilder(s).reverse())) {
                list.add(s);
                findAllPalindromicPermutation(i + 1, str, list, lists);
                list.removeLast();
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        findAllPalindromicPermutation(0, "xx", new LinkedList<>());
        findAllPalindromicPermutation(0, "madam", new LinkedList<>());
        findAllPalindromicPermutation(0, "nitin", new LinkedList<>());
        findAllPalindromicPermutation(0, "geeks", new LinkedList<>());
        System.out.println();
        System.out.println(findAllPalindromicPermutation(0, "xx", new LinkedList<>(), new ArrayList<>()));
        System.out.println(findAllPalindromicPermutation(0, "madam", new LinkedList<>(), new ArrayList<>()));
        System.out.println(findAllPalindromicPermutation(0, "nitin", new LinkedList<>(), new ArrayList<>()));
        System.out.println(findAllPalindromicPermutation(0, "geeks", new LinkedList<>(), new ArrayList<>()));
    }
}
