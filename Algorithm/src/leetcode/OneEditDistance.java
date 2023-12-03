package leetcode;

public class OneEditDistance {

    private static boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (n - m > 1) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                if (m < n) {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return m != n;
    }

    private static boolean isOneEditDistance(char[] c1, char[] c2) {
        if(c2.length - c1.length > 1) {
            return false;
        }
        int[] temp = new int[128];
        for (char x : c1) {
            temp[x]++;
        }
        for (char x : c2) {
            temp[x]--;
        }
        int count = 0;
        for (int x : temp) {
            if (x < 0) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab", "acb") + "\t" + isOneEditDistance("ab".toCharArray(), "acb".toCharArray()));
        System.out.println(isOneEditDistance("ad", "cab") + "\t" + isOneEditDistance("ad".toCharArray(), "cab".toCharArray()));
        System.out.println(isOneEditDistance("1203", "1213") + "\t" + isOneEditDistance("1203".toCharArray(), "1213".toCharArray()));
    }
}
