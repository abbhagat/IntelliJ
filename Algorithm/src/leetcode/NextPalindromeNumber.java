package leetcode;

// Time Complexity : O(d) d = Number of Digits in the number N
public class NextPalindromeNumber {

  private static String findNextPalindrome(long n) {
    char[] c = String.valueOf(n).toCharArray();
    int l = c.length;
    // Mirror i half to j half
    mirror(c);
    if (Long.parseLong(new String(c)) > n) {
      return new String(c);
    }
    // Increment the middle and propagate carry
    int i = (l - 1) / 2, j = l / 2;
    while (i >= 0 && c[i] == '9') {
      c[i] = c[j] = '0';
      i--;
      j++;
    }
    if (i < 0) {
      // Example: 9, 99, 999...
      return '1' + "0".repeat(l - 1) + '1';
    }
    c[i]++;
    c[j] = c[i];
    mirror(c);
    return new String(c);
  }

  private static void mirror(char[] n) {
    int i = 0, j = n.length - 1;
    while (i < j) {
      n[j] = n[i];
      i++;
      j--;
    }
  }

  public static void main(String[] args) {
    System.out.println(findNextPalindrome(9));            // 11
    System.out.println(findNextPalindrome(10));           // 11
    System.out.println(findNextPalindrome(3));            // 4
    System.out.println(findNextPalindrome(33));           // 44
    System.out.println(findNextPalindrome(13));           // 22
    System.out.println(findNextPalindrome(43));           // 44
    System.out.println(findNextPalindrome(47));           // 55
    System.out.println(findNextPalindrome(55));           // 66
    System.out.println(findNextPalindrome(99));           // 101
    System.out.println(findNextPalindrome(93));           // 99
    System.out.println(findNextPalindrome(101));          // 111
    System.out.println(findNextPalindrome(191));          // 202
    System.out.println(findNextPalindrome(199));          // 202
    System.out.println(findNextPalindrome(999));          // 1001
    System.out.println(findNextPalindrome(9999));         // 10001
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
