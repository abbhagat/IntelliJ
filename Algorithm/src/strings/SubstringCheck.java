package strings;

// Time  Complexity : O(n) where n is the length of s1
// Space Complexity : O(m) where m is the length of s2
public class SubstringCheck {

    private static void countSubString(String s1, String s2) {
        if (s2.contentEquals(s1)) {
            System.out.println(true + "\t" + 1);
        }
        if (s2.length() > s1.length()) {
            System.out.println(false + "\t" + 0);
        }
        String s = "";
        int index = -1, count = 0, j = 0;
        for (int i = 0; i < s1.length() && j < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                index = index == -1 ? i : index;
                s += s1.charAt(i);
                j++;
                if (s.contentEquals(s2)) {
                    count++;
                    i = index;
                    index = -1;
                    j = 0;
                    s = "";
                }
            } else {
                i = index == -1 ? i : index;
                index = -1;
                j = 0;
                s = "";
            }
        }
        System.out.println((count > 0) + "\t" + count);
    }

    private static void findAllSubString(String s1, String s2) {
        if (s2.equals(s1)) {
            System.out.println(true + "\t" + 1);
            return;
        }
        if (s2.length() > s1.length()) {
            System.out.println(false + "\t" + 0);
            return;
        }

        int count = 0;
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            if (s1.startsWith(s2, i)) {
                count++;
            }
        }
        System.out.println((count > 0) + "\t" + count);
    }

    public static void main(String[] args) {
        countSubString("ABC", "BC");
        countSubString("ABC", "DE");
        countSubString("ABC", "DEFG");
        countSubString("ABCABEABCDEF", "ABEABC");
        countSubString("ABCABEABCDEF", "ABEABC");
        countSubString("ABEFGCDEFG", "EFG");
        countSubString("ABEFAGCDEFG", "EFG");
    }
}
