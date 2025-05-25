package strings;

public class StringRotation {

    private static boolean isRotation(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    private static String leftRotation(String s, int k) {
        return s.substring(k) + s.substring(0, k);
    }

    private static String rightRotation(String s, int k) {
        k = s.length() - k;
        return s.substring(k) + s.substring(0, k);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("Password", "wordPass") ? "Rotation" : "Not Rotation");
        System.out.println(isRotation("Rotation", "tionRota") ? "Rotation" : "Not Rotation");
        System.out.println(leftRotation( "ABCDE", 2));   // CDEAB
        System.out.println(leftRotation( "12345", 2));   // 34512
        System.out.println(rightRotation("ABCDE", 2));  //  DEABC
        System.out.println(rightRotation("12345", 2));  //  45123
    }
}
