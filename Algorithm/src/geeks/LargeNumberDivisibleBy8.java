package geeks;

import static java.lang.Integer.parseInt;

public class LargeNumberDivisibleBy8 {

    private static boolean isDivisibleBy8(String s) {
        int l = s.length();
        int num = (l >= 1 && l <= 3) ? parseInt(s) : parseInt(s.substring(l - 3));
        return num % 8 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isDivisibleBy8("952") ? "Divisible" : "Not Divisible");
        System.out.println(isDivisibleBy8("752") ? "Divisible" : "Not Divisible");
    }
}
