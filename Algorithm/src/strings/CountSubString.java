package strings;

import java.util.HashSet;
import java.util.Set;

/*
 * 	Input  : S = "abcab"
   	Output : 7
   	There are 15 substrings of "abcab" :  a, ab, abc, abca, abcab, b, bc, bca ,bcab, c, ca, cab, a, ab, b
   	Out of the above substrings, there are 7 substrings : a, abca, b, bcab,c, a and b.

	Input  : S = "aba"
	Output : 4
	The substrings are a, b, ab and ba
	
 */

public class CountSubString {

    private static Set<String> set = new HashSet<>();

    private static void permute(int index, String s) {
        if (index != s.length()) {
            for (int i = index; i < s.length(); i++) {
                set.add("" + s.charAt(i));
                set.add(s.substring(i));
                if (i > 0) {
                    set.add(s.substring(0, i));
                }
            }
            permute(index + 1, s);
        }
    }

    public static void main(String[] args) {
        permute(0, "abcab");
        set.remove("abcab");
        System.out.println(set);
    }
}
