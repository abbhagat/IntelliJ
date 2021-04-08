package arrays;

public class LargeNumberDivisibleBy8 {

    private static final String number = "952";

    private static boolean isDivisibleBy8() {
        int length = number.length();
        int num;
        if (length >= 1 && length <= 3) {
            num = Integer.parseInt(number);
            if (num % 8 == 0) {
                return true;
            }
        } else if (length > 3) {
            num = Integer.parseInt(number.substring(number.length() - 3));
            if (num % 8 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isDivisibleBy8() ? "Divisible" : "Not Divisible");
    }
}
