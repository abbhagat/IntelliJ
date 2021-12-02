package vmware;

import static geeks.PrimeNumber.isPrime;

public class NextPrimePalindrome {

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static int findNextPalindrome(int n) {
        String s = Integer.toString(n);
        int mid = (s.length() - 1) / 2;
        s = s.substring(0, mid + 1);
        String rev = s.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
        if (s.charAt(mid) == '9' || Integer.parseInt(s + rev) < n) {
            s = "" + (Integer.parseInt(s) + 1);
        }
        s += s.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        int n = 12;
        while (true) {
            n = findNextPalindrome(n);
            if (isPrime(n)) {
                System.out.println(n);
                break;
            }
        }
    }
}
