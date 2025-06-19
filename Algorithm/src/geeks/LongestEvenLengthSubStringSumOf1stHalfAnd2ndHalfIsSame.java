package geeks;

/*
Given a string ‘str’ of digits, find the max of the longest substring of ‘str,’
such that the max of the substring is 2k digits and the sum of left k digits is equal to the sum of right k digits.
Examples: Input: str = "123123" Output: 6
The complete string is of even max and sum of first and second half digits is the same

Input: str = "1538023" Output: 4
The longest substring with the same first and second half sum is "5380"
*/
// Time  Complexity: O(n^2) where n is the length of the string
// Space Complexity: O(1)
public class LongestEvenLengthSubStringSumOf1stHalfAnd2ndHalfIsSame {

    private static void findLength(String s) {
        int max = 0;
        String maxString = "";
        for(int k = 0; k < s.length(); k++) {
            int leftSum = 0, rightSum = 0;
            for(int i = k, j = k + 1; i >= 0 && j < s.length(); i--, j++) {
                leftSum  += s.charAt(i) - '0';
                rightSum += s.charAt(j) - '0';
                if(leftSum == rightSum) {
                    String str = s.substring(i, j + 1);
                    if(maxString.length() < str.length()) {
                        max = str.length();
                        maxString = str;
                    }
                }
            }
        }
        System.out.println(maxString + "\t" + max);
    }

    public static void main(String[] args) {
        findLength("1538023");
        findLength("152380231");
    }
}
