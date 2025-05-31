package strings;

// Time  Complexity : O(n * m) where n is the length of s1 and m is the length of s2
// Space Complexity : O(m)     where m is the length of s2
public class SubstringCheck {

    private static void countSubString(String s1, String s2) {
        if (s2.contentEquals(s1)) {
            System.out.println(true + "\t" + 1);
        }
        if (s2.length() > s1.length()) {
            System.out.println(false + "\t" + 0);
        }
        String s = "";
        int index = -1, count = 0;
        boolean isSubString = false;
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                index = index == -1 ? i : index;
                s += s1.charAt(i);
                j++;
                if (s.contentEquals(s2)) {
                    isSubString = true;
                    count++;
                    i = index;
                    index = -1;
                    j = 0;
                    s = "";
                }
            } else {
                i = index != -1 ? index : i;
                index = -1;
                j = 0;
                s = "";
            }
        }
        System.out.println(isSubString + "\t" + count);
    }

    public static void main(String[] args) {
        countSubString("ABC", "BC");
        countSubString("ABC", "DE");
        countSubString("ABC", "DEFG");
        countSubString("ABCABEABCDEF", "ABEABC");
        countSubString("ABCABEABCDEF", "ABEABC");
        countSubString("ABEFGCDEFG",   "EFG");
        countSubString("ABEFAGCDEFG",  "EFG");
    }
}
