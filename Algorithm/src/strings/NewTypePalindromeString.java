package strings;

// Time Complexity log(n)
public class NewTypePalindromeString {

    private static boolean isNewTypePalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        int mid = (s.length() - 1) / 2;
        int lastIndex = s.lastIndexOf(s.charAt(0));
        if (lastIndex > mid) {
            String s1 = s.substring(lastIndex);
            char lastCharInS1 = s1.charAt(s1.length() - 1);
            int firstIndex = s.indexOf(lastCharInS1);
            if (firstIndex != -1 && firstIndex <= mid) {
                String s2 = s.substring(0, firstIndex + 1);
                return s1.equals(s2) && isNewTypePalindrome(s.substring(firstIndex + 1, lastIndex));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isNewTypePalindrome("")                  ? "Palindrome" : "Not Palindrome");
        System.out.println(isNewTypePalindrome("A")                 ? "Palindrome" : "Not Palindrome");
        System.out.println(isNewTypePalindrome("ABXCDYYDCXBA")      ? "Palindrome" : "Not Palindrome");
        System.out.println(isNewTypePalindrome("ABCEDABXYXABCEDAB") ? "Palindrome" : "Not Palindrome");
        System.out.println(isNewTypePalindrome("ABCDXYYXCDAB")      ? "Palindrome" : "Not Palindrome");
        System.out.println(isNewTypePalindrome("ABCDXYXDDAB")       ? "Palindrome" : "Not Palindrome");
    }
}
