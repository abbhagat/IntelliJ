package strings;

public class SubstringCheck {

    private static boolean isSubString(char[] s1, char[] s2) {
        int c = 0, k = 0, j = 0;
        int index = -1;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == s2[0]) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < s1.length; i++) {
                if (j < s2.length && s1[i] == s2[j]) {
                    c++;
                    j++;
                }
                if (c == s2.length) {
                    k++;
                    j = 0;
                    c = 0;
                }
            }
        }
        System.out.println("No of Substrings " + k);
        return k != 0 ? true : false;
    }

    private static boolean isSubString(String s1, String s2) {
        int count = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c2[0]) {
                String s = "";
                for (int j = i; (j < i + c2.length) && (j < c1.length); j++) {
                    s += c1[j];
                }
                if (s.equals(s2)) {
                    count++;
                }
            }
        }
        if (count != 0) {
            System.out.println("No of Substrings " + count);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubString("ABEFGCDEFG", "EFG") ? "Is a substring" : "Not a substring");
        System.out.println(isSubString("ABEFGCDEFG".toCharArray(), "EFG".toCharArray()) ? "Substring" : "Not Substring");
    }

}
