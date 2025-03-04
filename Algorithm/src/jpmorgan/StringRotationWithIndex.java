package jpmorgan;

public class StringRotationWithIndex {

    private static String rotate(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < end; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = start; i >= end; i--) {
            sb.append(s.charAt(i));
        }
        for (int i = start + 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(rotate(s, 3, 1));
        System.out.println(rotate(s, 4, 2));
    }
}
