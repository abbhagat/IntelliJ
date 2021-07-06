package geeks;

import static java.lang.Integer.parseInt;

public class LargeNumberDivisibleBy8 {

    private static boolean isDivisibleBy8(String number) {
        int length = number.length();
        int num = (length >= 1 && length <= 3) ? parseInt(number) : parseInt(number.substring(length - 3));
        return num % 8 == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isDivisibleBy8("952") ? "Divisible" : "Not Divisible");
    }
}
