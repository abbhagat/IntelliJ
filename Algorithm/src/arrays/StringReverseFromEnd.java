package arrays;

/*
 * Input  :- String str1 = "Today is Wednesday";
 * Output :- String str2 = "yadsendeW si yadoT"
 * Output :- String str2 = "yadoT si yadsendeW"
 */

public class StringReverseFromEnd {

    public static void main(String[] args) {
        String str = "Today is Wednesday";
        String s[] = str.split(" ");
        String string = "";
        for (int i = s.length - 1; i >= 0; i--) {
            char[] c = s[i].toCharArray();
            int j = 0, k = c.length - 1;
            for (j = 0; j < c.length / 2; j++, k--) {
                c[j] = (char)(c[j] ^ c[k]);
                c[k] = (char)(c[j] ^ c[k]);
                c[j] = (char)(c[j] ^ c[k]);
            }
            System.out.print(c);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < s.length; i++) {
            char[] c = s[i].toCharArray();
            int j = 0, k = c.length - 1;
            for (j = 0; j < c.length / 2; j++, k--) {
                c[j] = (char)(c[j] ^ c[k]);
                c[k] = (char)(c[j] ^ c[k]);
                c[j] = (char)(c[j] ^ c[k]);
            }
            System.out.print(c);
            System.out.print(" ");
        }
    }
}
