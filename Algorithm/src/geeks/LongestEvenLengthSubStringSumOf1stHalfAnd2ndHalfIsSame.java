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

    private static int findLength(String str, int n) {
        int maxLength = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = i, right = i + 1;
            int lsum = 0, rsum = 0;
            while (left >= 0 && right < n) {
                lsum += str.charAt(left) - '0';
                rsum += str.charAt(right) - '0';
                if (lsum == rsum) {
                    System.out.println(str.substring(left, right + 1));
                    maxLength = max(maxLength, right - left + 1);
                }
                left--;
                right++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = Integer.toString(1538023);
        System.out.println("Length of the substring is " + findLength(str, str.length()));
        str = Integer.toString(15380231);
        System.out.println("Length of the substring is " + findLength(str, str.length()));
    }
}
