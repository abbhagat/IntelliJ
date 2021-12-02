package vmware;

public class NextPalindromeNumber {

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String findNextPalindrome(int n) {
        String s = Integer.toString(n);
        int mid = s.length() / 2 - 1;
        s = s.substring(0, mid + 1);
        String rev = s.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
        if (s.charAt(mid) == '9' || Integer.parseInt(s + rev) < n) {
            s = "" + (Integer.parseInt(s) + 1);
        }
        s += s.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(findNextPalindrome(12));        // 121
        System.out.println(findNextPalindrome(123));      // 131
        System.out.println(findNextPalindrome(45312));   // 45354
        System.out.println(findNextPalindrome(12345));   // 12421
        System.out.println(findNextPalindrome(12945));   // 13031
        System.out.println(findNextPalindrome(4531));    // 4554
        System.out.println(findNextPalindrome(1459));   // 1551
        System.out.println(findNextPalindrome(1997));   // 2002
    }
}
