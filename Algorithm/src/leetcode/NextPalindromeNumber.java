package leetcode;

// Time Complexity : O(d) d = Number of Digits in the number N
public class NextPalindromeNumber {

  private static String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  private static String findNextPalindrome(long n) {
    String s = String.valueOf(n);
    switch (s.length()) {
      case 1:   s = (n >= 0 && n <= 8) ? String.valueOf(n + 1) : "11";
                break;
      case 2:   int c0 = s.charAt(0) - '0';
                int c1 = s.charAt(1) - '0';
                s = String.valueOf(c0 <= c1 ? c0 + 1 : c0);
                s += s.charAt(0);
                break;
      case 3:   s = s.substring(0, 2);
                s = String.valueOf((Long.parseLong(s) + 1));
                s += s.charAt(0);
                break;
      default:  String str = s;
                int mid = (s.length() - 1) / 2;
                s = s.substring(0, mid + 1);
                String rev = str.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
                if (s.charAt(mid) == '9' || Long.parseLong(s + rev) < n) {
                  s = String.valueOf(Long.parseLong(s) + 1);
                }
                s += str.length() % 2 == 1 ? reverse(s.substring(0, mid)) : reverse(s);
    }
    return s;
  }

  public static void main(String[] args) {
    System.out.println(findNextPalindrome(9));            // 11
    System.out.println(findNextPalindrome(10));           // 11
    System.out.println(findNextPalindrome(3));            // 4
    System.out.println(findNextPalindrome(33));           // 4
    System.out.println(findNextPalindrome(13));           // 22
    System.out.println(findNextPalindrome(43));           // 44
    System.out.println(findNextPalindrome(47));           // 55
    System.out.println(findNextPalindrome(55));           // 66
    System.out.println(findNextPalindrome(99));           // 101
    System.out.println(findNextPalindrome(93));           // 99
    System.out.println(findNextPalindrome(101));          // 111
    System.out.println(findNextPalindrome(191));          // 202
    System.out.println(findNextPalindrome(199));          // 202
    System.out.println(findNextPalindrome(141));          // 151
    System.out.println(findNextPalindrome(4531));         // 4554
    System.out.println(findNextPalindrome(1459));         // 1551
    System.out.println(findNextPalindrome(1997));         // 2002
    System.out.println(findNextPalindrome(45312));        // 45354
    System.out.println(findNextPalindrome(12345));        // 12421
    System.out.println(findNextPalindrome(12945));        // 13031
    System.out.println(findNextPalindrome(171152));       // 171171
    System.out.println(findNextPalindrome(9999999999L));  // 100000000001
  }
}
