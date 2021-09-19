package geeksforgeeks;

/*
A simple solution that comes to our mind is to sort all numbers in descending order, but simply sorting doesn’t work.
For example, 548 is greater than 60, but in output 60 comes before 548.
As a second example, 98 is greater than 9, but 9 comes before 98 in output.

So how do we go about it? The idea is to use any comparison based sorting algorithm.
In the used sorting algorithm, instead of using the default comparison,
write a comparison function myCompare() and use it to sort numbers.

Given two numbers X and Y, how should myCompare() decide which number to put first –
we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y).
If XY is larger, then X should come before Y in output, else Y should come before.
For example, let X and Y be 542 and 60.
To compare X and Y, we compare 54260 and 60542.
Since 60542 is greater than 54260, we put Y first.

Following is the implementation of the above approach.
To keep the code simple, numbers are considered as strings, the vector is used instead of a normal array.
 */

import java.util.ArrayList;
import java.util.List;

public class FormLargestNumberFromGivenArray {

    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        int countZero = 0;
        for (int x : nums) {
            list.add(Integer.toString(x));
            if (x == 0) {
                countZero++;
            }
        }
        if (countZero == nums.length) {
            return "0";
        }
        list.sort((x, y) -> (y + x).compareTo(x + y));
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
