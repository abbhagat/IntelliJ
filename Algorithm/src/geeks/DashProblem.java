package geeks;

/*
 *  1234567  --> 1234567
 *
 *  13244670 --> 1-32*4*4*670
 *
 *
 */

public class DashProblem {

    public static void main(String[] args) {

        String str = "1223504567";
        int[] c = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            c[i] = str.charAt(i) - 48;
        }
        String s = "";
        boolean prev_odd = false;
        boolean prev_even = false;
        if (c[0] % 2 == 0) {
            prev_even = true;
        } else {
            prev_odd = true;
        }
        int i;
        for (i = 1; i < c.length; i++) {
            s += c[i - 1];
            if (c[i] == 0) {
                s += c[i];
                i++;
            }
            if (c[i] % 2 == 0 && prev_even) {
                s += "*";
            }
            if (c[i] % 2 != 0 && prev_odd) {
                s += "-";
            }
            if (c[i] % 2 == 0) {
                prev_even = true;
                prev_odd = false;
            } else {
                prev_odd = true;
                prev_even = false;
            }

        }
        s += c[i - 1];
        System.out.println(s);
    }
}
