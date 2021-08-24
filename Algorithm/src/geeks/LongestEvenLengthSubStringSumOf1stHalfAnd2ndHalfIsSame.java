package geeks;

/*
Given a string ‘str’ of digits, find the maxLength of the longest substring of ‘str’,
such that the maxLength of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
Examples :
Input: str = "123123" Output: 6
The complete string is of even maxLength and sum of first and second half digits is same

Input: str = "1538023" Output: 4
The longest substring with same first and second half sum is "5380"
*/

import static java.lang.Math.max;

public class LongestEvenLengthSubStringSumOf1stHalfAnd2ndHalfIsSame {

    private static int findLength(String str, int left, int right) {
        if (left > right) {
            return -1;
        }
        int lsum = 0, rsum = 0;
        String s = "";
        while (left >= 0 && right < str.length()) {
            lsum += str.charAt(left) - '0';
            rsum += str.charAt(right) - '0';
            if (lsum == rsum) {
                System.out.println(str.substring(left, right + 1));
                break;

            }
            left--;
            right++;
        }
        return right - left + 1;
    }

    private static int findLength(String str, int n) {
        int maxLength = 0;                       // Initialize result
        for (int i = 0; i < n - 1; i++) {      // Consider all possible midpoints one by one
            int l = i, r = i + 1;              // For current midpoint 'i', keep expanding substring on both sides, if sum of both sides becomes equal update maxLength
            int lsum = 0, rsum = 0;           // initialize left and right sum
            while (r < n && l >= 0) {        // move on both sides till indexes go out of bounds
                lsum += str.charAt(l) - '0';
                rsum += str.charAt(r) - '0';
                if (lsum == rsum) {
                    System.out.println(str.substring(l, r + 1));
                    maxLength = max(maxLength, r - l + 1);
                }
                l--;
                r++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "1538023";
        System.out.println("Length of the substring is " + findLength(str, str.length()));
        int maxLength = 1;
        for (int i = 0; i < str.length(); i++) {
            int length = findLength(str, i, i);
            maxLength = max(maxLength, length);
            length = findLength(str, i, i + 1);
            maxLength = max(maxLength, length);
        }
        System.out.println("Length of the substring is " + maxLength);
    }
}
