package strings;

public class StringReverseWordByWord {

    public static void main(String[] args) {
        String str = "Java is an OOP";
        for (String s : str.split(" ")) {
            char[] c = s.toCharArray();
            int j = c.length - 1;
            for (int i = 0; i < c.length / 2; i++, j--) {
                c[i] = (char) (c[i] ^ c[j]);
                c[j] = (char) (c[i] ^ c[j]);
                c[i] = (char) (c[i] ^ c[j]);
            }
            for (char x : c) {
                System.out.print(x);
            }
            System.out.print(" ");
        }
    }
}
