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
        int max = 0;
        for (int k = 0; k < s.length(); k++) {
            int i = k, j = k + 1, lsum = 0, rsum = 0;
            while (i >= 0 && j < s.length()) {
                lsum += s.charAt(i) - '0';
                rsum += s.charAt(j) - '0';
                if (lsum == rsum) {
                    int length = j - i + 1;
                    System.out.print(s.substring(i, j + 1));
                    max = max(max, length);
                }
                i--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("\t" + findLength("1538023"));
        System.out.println("\t" + findLength("152380231"));
    }
}
