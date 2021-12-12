package strings;


/*
Input : s = "GeeksforGeeks"
        d = 2
Output : Left Rotation  : "eksforGeeksGe"
         Right Rotation : "ksGeeksforGee"


Input : s = "qwertyu"
        d = 2
Output : Left rotation  : "ertyuqw"
         Right rotation : "yuqwert"
 */

public class StringRotation {

    private static boolean isRotation(String s1, String s2) {
        return s1.length() == s2.length() ? (s1 + s1).contains(s2) : false;
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
        System.out.println(isRotation("Password", "swordPas") ? "Rotation" : "Not Rotation");
        System.out.println(leftRotation( "GeeksforGeeks", 2));
        System.out.println(rightRotation("GeeksforGeeks", 2));
    }
}
