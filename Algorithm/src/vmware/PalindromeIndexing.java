package vmware;


/*
      Time complexity : O(N)
      Space Complexity: O(1)
 */
public class PalindromeIndexing {

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
