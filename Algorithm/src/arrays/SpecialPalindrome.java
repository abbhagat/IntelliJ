package arrays;

public class SpecialPalindrome {

    private static boolean palindrome(int num) {
        return num == reverse(num) ? true : false;
    }

    static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            int k = num % 10;
            rev = (rev * 10) + k;
            num /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int num = 195;
        while (true) {
            if (palindrome(num)) {
                System.out.println(num);
                break;
            }
            num = num + reverse(num);
        }
    }
}
