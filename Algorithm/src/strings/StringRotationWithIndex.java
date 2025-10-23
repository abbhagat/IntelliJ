package strings;

public class StringRotationWithIndex {

    private static StringBuilder rotate(String s, int start, int end) {
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
        return sb;
    }

    private static String rotateString(String str, int start, int end) {
        String s1 = str.substring(0, end);
        String s2 = str.substring(start + 1);
        String s3 = str.substring(end, start + 1);
        return s1 + new StringBuilder(s3).reverse() + s2;
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(rotate(s, 3, 1) + "\t" + rotateString(s, 3, 1));
        System.out.println(rotate(s, 4, 2) + "\t" + rotateString(s, 4, 2));
    }
}
