package geeks;

/*
Given a string ‘str’ of digits, find the max of the longest substring of ‘str’,
such that the max of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
Examples :
Input: str = "123123" Output: 6
The complete string is of even max and sum of first and second half digits is same

Input: str = "1538023" Output: 4
The longest substring with same first and second half sum is "5380"
*/

import static java.lang.Integer.max;

public class LongestEvenLengthSubStringSumOf1stHalfAnd2ndHalfIsSame {

    private static int findLength(String s) {
        int max = Integer.MIN_VALUE;
        for(int k = 0; k < s.length(); k++) {
            int leftSum = 0, rightSum = 0;
            for(int i = k, j = k + 1; i >= 0 && j < s.length(); i--, j++) {
                leftSum  += s.charAt(i) - '0';
                rightSum += s.charAt(j) - '0';
                if(leftSum == rightSum) {
                    int length = j - i + 1;
                    System.out.print(s.substring(i, j + 1) + "\t");
                    max = max(max, length);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLength("1538023"));
        System.out.println(findLength("152380231"));
    }
}
