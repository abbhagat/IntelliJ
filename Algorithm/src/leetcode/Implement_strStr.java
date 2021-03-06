package leetcode;

public class Implement_strStr {

    public static int strStr(String s1, String s2) {
        if (s2.equals("") || s1.equals(s2)) {
            return 0;
        }
        if (s2.length() > s1.length()) {
            return -1;
        }
        int index = -1;
        String s = "";
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                index = index == -1 ? i : index;
                s += s1.charAt(i);
                j++;
            } else if (s.equals(s2)) {
                break;
            } else {
                i = index != -1 ? index : i;
                index = -1;
                j = 0;
                s = "";
            }
        }
        return s.equals(s2) ? index : -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("abc", "c"));
    }
}
