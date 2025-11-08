package strings;

public class StringReverse {

    public static void main(String[] args) {
        String s = "Java is an OOP";
        char[] c = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            c[i] = (char) (c[i] ^ c[j]);
            c[j] = (char) (c[i] ^ c[j]);
            c[i] = (char) (c[i] ^ c[j]);
        }
        System.out.println(c);
    }
}
