package geeks;

/*
 *  1234567  --> 1234567
 *
 *  13244670 --> 1-32*4*4*670
 */

public class DashProblem {

    private static StringBuilder dashProblem(String str) {
        int[] a = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
              a[i] = str.charAt(i) - '0';
        }
        boolean prev_odd  = false;
        boolean prev_even = false;
        if (a[0] % 2 == 0) {
            prev_even = true;
        } else {
            prev_odd  = true;
        }
        int i;
        StringBuilder sb = new StringBuilder();
        for (i = 1; i < a.length; i++) {
            sb.append(a[i - 1]);
            if (a[i] == 0) {
                continue;
            }
            if (a[i] % 2 == 0 && prev_even) {
                sb.append("*");
            }
            if (a[i] % 2 != 0 && prev_odd) {
                sb.append("-");
            }
            if (a[i] % 2 == 0) {
                prev_even = true;
                prev_odd = false;
            } else {
                prev_odd = true;
                prev_even = false;
            }
        }
        sb.append(a[i - 1]);
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(dashProblem("1234567"));
        System.out.println(dashProblem("13244670"));
        System.out.println(dashProblem("1223504567"));
    }
}
