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

    private static int findLength(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int left = i, right = i + 1;
            int lsum = 0, rsum = 0;
            while (left >= 0 && right < s.length()) {
                lsum += s.charAt(left ) - '0';
                rsum += s.charAt(right) - '0';
                if (lsum == rsum) {
                    System.out.println(s.substring(left, right + 1));
                    maxLength = max(maxLength, right - left + 1);
                }
                left--;
                right++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("1538023"));
        System.out.println(findLength("15380231"));
    }
}
