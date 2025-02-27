package leetcode;

// Time  Complexity  O(log n)

public class IntegerToRoman {
    private static final int[] INTEGER = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static String intToRoman(int n) {
        for (int i = 0; i < INTEGER.length; i++) {
            if (n >= INTEGER[i]) {
                return ROMANS[i] + intToRoman(n - INTEGER[i]);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(10));
        System.out.println(intToRoman(11));
        System.out.println(intToRoman(99));
        System.out.println(intToRoman(101));
        System.out.println(intToRoman(102));
        System.out.println(intToRoman(510));
        System.out.println(intToRoman(3549));
    }
}
