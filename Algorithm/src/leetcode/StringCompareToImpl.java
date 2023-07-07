package leetcode;

public class StringCompareToImpl {

    private static int compareTo(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s1 == null || s2 == null) {
            return s1 == null ? -1 : 1;
        }
        if (s1.isEmpty() && s2.isEmpty()) {
            return 0;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        if (s1.length() < s2.length()) {
            return -1;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) > s2.charAt(i) ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Java.compareTo(Java)  " + compareTo("Java", "Java"));
        System.out.println("Javaa.compareTo(Java) " + compareTo("Javaa", "Java"));
        System.out.println("Java.compareTo(Javaa) " + compareTo("Java", "Javaa"));
    }
}
