package arrays;

public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";
        System.out.println(lps(s));
    }

    private static int lps(String s) {
        int n = s.length();
        int a[] = new int[n]; // a[i] is going to store length of longest palindromic subsequence of substring s[0..i]

        for (int i = n - 1; i >= 0; i--) {  // Pick starting point
            int back_up = 0;
            for (int j = i; j < n; j++) { // Pick ending points and see if s[i] increases length of longest common subsequence ending with s[j].

                if (j == i) {             // similar to 2D array L[i][j] == 1 i.e., handling substrings of length one.
                    a[j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {  // Similar to 2D array L[i][j] = L[i+1][j-1]+2 i.e. handling case when corner characters are same.
                    int temp = a[j];
                    a[j] = back_up + 2;
                    back_up = temp;
                } else {                                 // similar to 2D array L[i][j] = max(L[i][j-1],a[i+1][j])
                    back_up = a[j];
                    a[j] = Math.max(a[j - 1], a[j]);
                }
            }
        }
        return a[n - 1];
    }

}
