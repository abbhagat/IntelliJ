package vmware;


/*
      Time complexity : O(N)
      Space Complexity: O(1)
 */
public class PalindromeIndexing {

    private static int palindromeIndexing(String s) {
        int j = s.length() - 1;
        for (int i = 0; i <= j / 2; i++) {
            if (s.charAt(i) != s.charAt(j - i)) {
                if (s.charAt(i + 1) == s.charAt(j - i) && s.charAt(i + 2) == s.charAt(j - i - 1)) {
                    return i;
                }
                if (s.charAt(i) == s.charAt(j - i - 1)) {
                    return j - i;
                }
            }
        }
        return -1;
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    private static int findPalindromeIndex(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                if (isPalindrome(s, low + 1, high)) {
                    return low;
                }
                if (isPalindrome(s, low, high - 1)) {
                    return high;
                }
                return -1;
            }
        }
        return -2;
    }

    public static void main(String[] args) {
        String s = "MAXDAM";
        int low = 0, high = s.length() - 1;
        int index = findPalindromeIndex(s, low, high);
        switch (index) {
            case -1:
                System.out.println("Not Possible");
                break;
            case -2:
                System.out.println("Possible Without Removing");
                break;
            default:
                System.out.println("Possible by removing character at index " + index);
        }
    }
}
