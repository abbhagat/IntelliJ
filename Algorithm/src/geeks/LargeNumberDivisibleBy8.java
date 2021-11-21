package geeks;

import static java.lang.Integer.parseInt;

public class LargeNumberDivisibleBy8 {

    private static boolean isDivisibleBy8(String n) {
        int l = n.length();
        int num = (l >= 1 && l <= 3) ? parseInt(n) : parseInt(n.substring(l - 3));
        return num % 8 == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isDivisibleBy8("952") ? "Divisible" : "Not Divisible");
    }
}
