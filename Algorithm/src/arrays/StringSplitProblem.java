package arrays;

public class StringSplitProblem {

    static boolean hasAllCharactersPresent(String s1, String s2) {
        for (char c : s2.toCharArray()) {
            if (s1.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "spqrstrupvsqw";
        String s2 = "sprt";
        String s3 = "q";
        String strToBeFound = null, strToBeFound1 = null, strToBeFound2 = null;
        String[] str = s1.split(s3);
        for (String s : str) {
            if (s.length() < s2.length()) {
                continue;
            }
            if (hasAllCharactersPresent(s, s2)) {
                int j = s.length() - 1;
                for (int i = 1; i < s.length() && i < s2.length(); i++) {
                    if (hasAllCharactersPresent(s.substring(i), s2)) {
                        strToBeFound1 = s.substring(i);
                        if (hasAllCharactersPresent(s.substring(i, j - 1), s2)) {
                            strToBeFound2 = s.substring(i, j - 1);
                            j--;
                        }
                        strToBeFound = strToBeFound1.length() <= strToBeFound2.length() ? strToBeFound1 : strToBeFound2;
                    }
                }
            }
        }
        System.out.println(strToBeFound);
    }
}
