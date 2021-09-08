package geeksforgeeks;

public class StringCompression {

    public static void main(String[] args) {
        char[] c = {'a'};
        if (c.length == 1) {
            System.out.println(c[0]);
        } else {
            int i, count = 1;
            String s = "";
            for (i = 1; i < c.length; i++) {
                if (c[i] - c[i - 1] == 0) {
                    count++;
                    continue;
                } else {
                    s += "" + c[i - 1] + count;
                    count = 1;
                }
            }
            s += "" + c[i - 1] + count;
            System.out.println(s);
            for (i = 0; i < c.length; i++) {
                c[i] = i < s.length() ? s.charAt(i) : ' ';
            }
            for (char x : c) {
                System.out.print(x + " ");
            }
        }
    }
}