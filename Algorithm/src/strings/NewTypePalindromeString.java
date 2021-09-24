package strings;

/**
 * ABXCDYYDCXBA is a palindrome
 */

public class NewTypePalindromeString {

    private static boolean isNewTypePalindrome(String s) {
        while (true) {
            if (s.isEmpty() || s.length() == 1) {
                return true;
            }
            char[] a = s.toCharArray();
            int mid = (a.length - 1) / 2;
            int lastIndex = s.lastIndexOf(a[0]);
            if (lastIndex > mid) {
                String s1 = s.substring(lastIndex);
                char lastCharInS1 = s1.charAt(s1.length() - 1);
                int firstIndex = s.indexOf(lastCharInS1);
                if (firstIndex <= mid && firstIndex != -1) {
                    String s2 = s.substring(0, firstIndex + 1);
                    if (!s1.equals(s2)) {
                        return false;
                    }
                    s = s.substring(firstIndex + 1, lastIndex);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(isNewTypePalindrome("") ? "Palindrome" : "Not Palindrome");
//        System.out.println(isNewTypePalindrome("A") ? "Palindrome" : "Not Palindrome");
        System.out.println(isNewTypePalindrome("ABCEDABXYXABCEDAB") ? "Palindrome" : "Not Palindrome");
//        System.out.println(isNewTypePalindrome("ABCDXYYXCDAB") ? "Palindrome" : "Not Palindrome");
//        System.out.println(isNewTypePalindrome("ABCDXYXDDAB") ? "Palindrome" : "Not Palindrome");
    }
}
