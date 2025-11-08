package leetcode;

// Time  Complexity  O(log n)
public class IntegerToRoman {

    private static final int[] INTEGER = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static String intToRoman(int n, int index) {
        for (int i = index; i < INTEGER.length; i++) {
            if (n >= INTEGER[i]) {
                return ROMANS[i] + intToRoman(n - INTEGER[i], i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3, 0));
        System.out.println(intToRoman(10, 0));
        System.out.println(intToRoman(11, 0));
        System.out.println(intToRoman(99, 0));
        System.out.println(intToRoman(101, 0));
        System.out.println(intToRoman(102, 0));
        System.out.println(intToRoman(510, 0));
        System.out.println(intToRoman(3549, 0));
    }
}
