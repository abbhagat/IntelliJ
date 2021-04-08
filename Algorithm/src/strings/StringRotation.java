package strings;

public class StringRotation {

    private static boolean isRotation(String s1, String s2) {

        if (s1.length() == s2.length()) {
            String s3 = s1 + s1;
            int startIdx = s3.indexOf(s2.charAt(0));
            if (-1 != startIdx) {
                String s4 = s3.substring(startIdx, startIdx + s2.length());
                return s2.equals(s4) ? true : false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("Password", "wordPass") ? "Rotation" : "Not Rotation");
        System.out.println(isRotation("Passwodr", "wordPass") ? "Rotation" : "Not Rotation");
    }
}
