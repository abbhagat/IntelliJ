package strings;

public class SubstringCheck {

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
    }

}
