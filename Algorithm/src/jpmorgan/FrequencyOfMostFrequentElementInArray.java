package jpmorgan;

import java.util.Arrays;
import static java.lang.Integer.max;

/**
The frequency of an element is the number of times it occurs in an array.
You are given an int a[] and an integer k. In one operation, you can choose an index of a[] and increment the element at that index by 1.
Return the maximum possible frequency of an element after performing at most k operations.
Example 1:
Input: a = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make a = [4,4,4].
4 has a frequency of 3.
Example 2:
Input: a = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first  element three times to make a = [4,4,8,13].   4 has a frequency of 2.
- Increment the second element four  times to make a = [1,8,8,13].   8 has a frequency of 2.
- Increment the third  element five  times to make a = [1,4,13,13]. 13 has a frequency of 2.
Example 3:
Input: a = [3,9,6], k = 2
Output: 1
*/

// Time Complexity : O(n log n)
public class FrequencyOfMostFrequentElementInArray {

    public static int maxFrequency(int[] a, int k) {
        Arrays.sort(a);
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < a.length; i++) {
            sum += a[i];                               //  Add the current element to the sum
            while (a[i] * (i - j + 1) > sum + k) {    //  Adjust the left pointer to maintain the frequency constraint
                sum -= a[j];                         //  Subtract the leftmost element from the sum
                j++;
            }
            max = max(max, i - j + 1);          // Update the maximum frequency
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(maxFrequency(new int[]{3, 9, 6}, 2));
        System.out.println(maxFrequency(new int[]{1, 4, 8, 13}, 5));
    }
}
