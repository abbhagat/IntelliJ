package gfg;

/*
    The first Palindromic Numbers of length 1 are 1, 2, 3, 4, 5, 6, 7, 8, and 9.
    The first Palindromic Numbers of length 3 is 101, which is the 10th smallest odd length palindrome number.
    Similarly, 11th, 12th, 13th, …, 99th smallest palindromic numbers are 111, 121, 131 …, 999 respectively.
    Therefore, the Kth smallest odd length palindrome number can be formed by joining K and the reverse of K except the last digit.
    From the above observations, the Kth smallest odd length palindromic number is given by appending the reverse of all the digits
    of K except the last one at the end of K.
 */
public class KthSmallestOddLengthPalindrome {

    private static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int k = n % 10;
            rev = rev * 10 + k;
            n /= 10;
        }
        return rev;
    }

    private static String findKthSmallestOddLengthPalindrome(int n) {
        return n + "" + reverse(n) % 10;
    }

    public static void main(String[] args) {
        System.out.println(findKthSmallestOddLengthPalindrome(10));
        System.out.println(findKthSmallestOddLengthPalindrome(11));
    }
}
