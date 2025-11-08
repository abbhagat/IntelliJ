package vmware;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class IsSubsequenceString {

    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "axbgdc"));
    }
}
