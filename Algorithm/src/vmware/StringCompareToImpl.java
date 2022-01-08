package vmware;

public class StringCompareToImpl {

    private static int compareTo(String s1, String s2) {
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.charAt(i) > s2.charAt(i) ? 1 : -1;
                }
            }
            return 0;
        }
        return s1.length() > s2.length() ? 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println("Java.compareTo(Java)  " + compareTo("Java", "Java"));
        System.out.println("Javaa.compareTo(Java) " + compareTo("Javaa", "Java"));
        System.out.println("Java.compareTo(Javaa) " + compareTo("Java", "Javaa"));
    }
}
