package goldmansach;

/*
 * Input  :- String str = "Today is Wednesday";
 * Output :- String str = "Wednesday is Today"
 *
 */

public class ReadStringFromEnd {

    public static void main(String[] args) {
        String str = "Today is Wednesday";
        String s[] = str.split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.print(s[i] + " ");
        }
        String x = "";
        System.out.println();
        char c[] = (" " + str).toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] != ' ') {
                x = c[i] + x;
            } else {
                System.out.print(x);
                x = "";
            }
        }
    }
}
