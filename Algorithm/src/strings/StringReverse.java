package strings;

import java.util.stream.IntStream;

public class StringReverse {

    public static void main(String[] args) {
        String s = "Java is an OOP";
        char[] c = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        for (i = 0; i < s.length() / 2; i++, j--) {
            c[i] = (char) (c[i] ^ c[j]);
            c[j] = (char) (c[i] ^ c[j]);
            c[i] = (char) (c[i] ^ c[j]);
        }
        IntStream.range(0, c.length).forEach(x -> System.out.print(c[x]));
    }
}
