package geeks;

public class LargeNumberDivisibleBy8 {

    private static boolean isDivisibleBy8(String s) {
        s = !s.isEmpty() && s.length() <= 3 ? s :  s.substring(s.length() - 3);
        return Integer.parseInt(s) % 8 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isDivisibleBy8("64")   ? "Divisible" : "Not Divisible");
        System.out.println(isDivisibleBy8("952")  ? "Divisible" : "Not Divisible");
        System.out.println(isDivisibleBy8("1952") ? "Divisible" : "Not Divisible");
        System.out.println(isDivisibleBy8("1752") ? "Divisible" : "Not Divisible");
    }
}
