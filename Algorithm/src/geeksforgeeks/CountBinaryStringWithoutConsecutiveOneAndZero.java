package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

/*
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Examples:

Input:  N = 2
Output: 3
// The 3 strings are 00, 01, 10

Input: N = 3
Output: 5
// The 5 strings are 000, 001, 010, 100, 101

This problem can be solved using Dynamic Programming.
Let a[i] be the number of binary strings of length i which do not contain any two consecutive 1’s and which end in 0.
Let b[i] be the number of binary strings of length i which do not contain any two consecutive 1’s and which end in 1.
We can append either 0 or 1 to a string ending in 0,but we can only append 0 to a string ending in 1.

This yields the recurrence relation:

a[i] = a[i - 1] + b[i - 1]
b[i] = a[i - 1]
The base cases of above recurrence are a[1] = b[1] = 1.
The total number of strings of length i is just a[i] + b[i].
Following is the implementation of above solution.
In the following implementation, indexes start from 0. So a[i] represents the number of binary strings for input length i+1.
Similarly, b[i] represents binary strings for input length i+1.
 */
public class CountBinaryStringWithoutConsecutiveOneAndZero {

    private static List<String> list = new ArrayList<>();

    private static void permutation(String s, int itr) {
        if (itr == 0) {
            list.add(s);
        } else {
            permutation(s + "0", itr - 1);
            permutation(s + "1", itr - 1);
        }
    }

    private static int countStrings(int n) {
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        return a[n - 1] + b[n - 1];
    }

    private static int countStringsZero(int n) {
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = b[i - 1];
            b[i] = a[i - 1] + b[i - 1];
        }
        return a[n - 1] + b[n - 1];
    }

    public static void main(String args[]) {
        System.out.println(countStrings(3));
        System.out.println(countStringsZero(3));
        permutation("", 3);
        int count = 0;
        for (String s : list) {
            if (!s.contains("11")) {
                System.out.println(s);
                count++;
            }
        }
        System.out.println(count);
    }
}
