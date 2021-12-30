package geeks;

public class ParseInt {

    public static void main(String[] args) {
        String s = "1203450.12345";
        int idx = s.indexOf('.');
        String s1 = s.substring(0, idx);
        String s2 = s.substring(idx + 1);
        System.out.println(s1 + "\t" + s2);
        char[] c = s1.toCharArray();
        int sum1 = 0;
        int mul = 1;
        for (int i = c.length - 1; i >= 0; i--) {
            sum1 += (c[i] - '0') * mul;
            mul *= 10;
        }
        c = s2.toCharArray();
        int sum2 = 0;
        mul = 1;
        for (int i = c.length - 1; i >= 0; i--) {
            sum2 += (c[i] - '0') * mul;
            mul *= 10;
        }
        System.out.println(sum1 + "." + sum2);
    }
}
