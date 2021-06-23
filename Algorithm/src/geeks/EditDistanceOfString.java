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
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(editDist("sunday".toCharArray(), "saturday".toCharArray()));
    }
}
