package geeks;

/*
 *  1234567  --> 1234567
 *
 *  13244670 --> 1-32*4*4*670
 */

public class DashProblem {

    public static void main(String[] args) {
        String str = "1223504567";
        int[] a = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            a[i] = str.charAt(i) - 48;
        }
        String s = "";
        boolean prev_odd  = false;
        boolean prev_even = false;
        if (a[0] % 2 == 0) {
            prev_even = true;
        } else {
            prev_odd = true;
        }
        int i;
        for (i = 1; i < a.length; i++) {
            s += a[i - 1];
            if (a[i] == 0) {
                s += a[i];
                i++;
            }
            if (a[i] % 2 == 0 && prev_even) {
                s += "*";
            }
            if (a[i] % 2 != 0 && prev_odd) {
                s += "-";
            }
            if (a[i] % 2 == 0) {
                prev_even = true;
                prev_odd = false;
            } else {
                prev_odd = true;
                prev_even = false;
            }
        }
        s += a[i - 1];
        System.out.println(s);
    }
}
