package vmware;

public class NextPalindromeNumber {

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String findNextPalindrome(int n) {
        String s = Integer.toString(n);
        if (s.length() == 1) {
            return "11";
        }
        if (s.length() == 2) {
            s = "" + (s.charAt(0) - '0' + 1);
            return s + s.charAt(0);
        }
        if (s.length() == 3) {
            s = s.substring(0, 2);
            s = "" + (Integer.parseInt(s) + 1);
            return s + s.charAt(0);
        }
        int mid = (s.length() - 1) / 2;
        s = s.substring(0, mid + 1);
        String rev = s.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
        if (s.charAt(mid) == '9' || Integer.parseInt(s + rev) < n) {
            s = "" + (Integer.parseInt(s) + 1);
        }
        s += s.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(findNextPalindrome(9));      // 11
        System.out.println(findNextPalindrome(3));      // 11
        System.out.println(findNextPalindrome(13));     // 22
        System.out.println(findNextPalindrome(55));     // 66
        System.out.println(findNextPalindrome(99));     // 101
        System.out.println(findNextPalindrome(93));     // 101
        System.out.println(findNextPalindrome(101));    // 111
        System.out.println(findNextPalindrome(191));    // 202
        System.out.println(findNextPalindrome(141));    // 151
        System.out.println(findNextPalindrome(45312));  // 45354
        System.out.println(findNextPalindrome(12345));  // 12421
        System.out.println(findNextPalindrome(12945));  // 13031
        System.out.println(findNextPalindrome(4531));   // 4554
        System.out.println(findNextPalindrome(1459));   // 1551
        System.out.println(findNextPalindrome(1997));   // 2002

    }
}
