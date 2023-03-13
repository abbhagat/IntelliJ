package vmware;

public class NextPalindromeNumber {

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String findNextPalindrome(int n) {
        String s = Integer.toString(n);
        switch (s.length()) {

            case 1 : s = (n >= 0 && n <= 8) ? Integer.toString(n + 1) : "11";
                     break;
            case 2 : int k = s.charAt(0) - '0';
                     s = (k <= s.charAt(1) - '0') ? Integer.toString(k + 1) : Integer.toString(k);
                     s += s.charAt(0);
                     break;
            case 3 : s = s.substring(0, 2);
                     s = Integer.toString((Integer.parseInt(s) + 1));
                     s += s.charAt(0);
                     break;
            default: int mid = (s.length() - 1) / 2;
                     s = s.substring(0, mid + 1);
                     String rev = s.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
                     if (s.charAt(mid) == '9' || Integer.parseInt(s + rev) < n) {
                         s = "" + (Integer.parseInt(s) + 1);
                     }
                     s += s.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(findNextPalindrome(9));      // 11
        System.out.println(findNextPalindrome(3));      // 4
        System.out.println(findNextPalindrome(13));     // 22
        System.out.println(findNextPalindrome(43));     // 44
        System.out.println(findNextPalindrome(47));     // 55
        System.out.println(findNextPalindrome(55));     // 66
        System.out.println(findNextPalindrome(99));     // 101
        System.out.println(findNextPalindrome(93));     // 101
        System.out.println(findNextPalindrome(101));    // 111
        System.out.println(findNextPalindrome(191));    // 202
        System.out.println(findNextPalindrome(199));    // 202
        System.out.println(findNextPalindrome(141));    // 151
        System.out.println(findNextPalindrome(4531));   // 4554
        System.out.println(findNextPalindrome(1459));   // 1551
        System.out.println(findNextPalindrome(1997));   // 2002
        System.out.println(findNextPalindrome(45312));  // 45354
        System.out.println(findNextPalindrome(12345));  // 12421
        System.out.println(findNextPalindrome(12945));  // 13031
    }
}
