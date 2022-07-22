package interview;

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
                } else if (m < n) {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return m != n;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab", "acb"));
        System.out.println(isOneEditDistance("ad", "cab"));
        System.out.println(isOneEditDistance("1203", "1213"));
    }
}
