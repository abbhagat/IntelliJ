package strings;

public class SubstringCheck {

    private static boolean subString(String s1, String s2) {
        if (s2.equals("") || s1.equals(s2)) {
            return true;
        }
        if (s2.length() > s1.length()) {
            return false;
        }
        int i = 0, j = 0, index = -1;
        String s = "";
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                index = index == -1 ? i : index;
                s += s1.charAt(i);
                j++;
            } else if (s.equals(s2)) {
                return true;
            } else {
                i = index != -1 ? index : i;
                index = -1;
                j = 0;
                s = "";
            }
            i++;
        }
        return s.equals(s2) ? true : false;
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
        System.out.println(isSubString("ABEFGCDEFG", "EFG") ? "Is A substring" : "Not A substring");
        System.out.println(  subString("ABEFAGCDEFG","EFG") ? "Is A substring" : "Not A substring");
    }
}
