package geeks;

/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations.
Replace 'n' with 'r', insert t, insert a
 */
public class EditDistanceOfString {

    private static int editDist(char[] c1, char[] c2) {
        int[] temp = new int[128];
        for (char x : c1) {
            temp[x]++;
        }
        for (char x : c2) {
            temp[x]--;
        }
        int count = 0;
        for (int x : temp) {
            if (x < 0) {
                count += x;
            }
        }
        return Math.abs(count);
    }

    private static int editDist(String str1, String str2, int m, int n) {
        if (m == 0) {  // If first string is empty, the only option is to insert all characters of second string into first
            return n;
        }

        if (n == 0) {  // If second string is empty, the only option is to remove all characters of first string
            return m;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {  // If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings.
            return editDist(str1, str2, m - 1, n - 1);
        }
        // If last characters are not same, consider all three operations on last character of first string, recursively compute minimum cost for all
        // three operations and take minimum of three values.
        return 1 + min(editDist(str1, str2, m, n - 1), // Insert
                       editDist(str1, str2, m - 1, n), // Remove
                       editDist(str1, str2, m - 1, n - 1) // Replace
                      );
    }

    private static int min(int x, int y, int z) {
        return x < y ? x < z ? x : z : y < z ? y : z;
    }

    public static void main(String[] args) {
        System.out.println(editDist("sunday".toCharArray(), "saturday".toCharArray()));
    }
}
