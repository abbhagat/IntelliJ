package gfg;

public class DoubleBasePalindrome {

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static String decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        int carry = 0;
        while (n != 0) {
            carry = n / 2;
            binary.insert(0, n % 2);
            n /= 2;
        }
        return carry == 0 ? binary.toString() : "1" + binary;
    }

    private static int doubleBasePalindrome(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i);
            String binary = decimalToBinary(i);
            if (isPalindrome(binary) && isPalindrome(s)) {
                System.out.println(s + "\t" + binary);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Count := " + doubleBasePalindrome(100));
        System.out.println("Count := " + doubleBasePalindrome(101));
    }
}
