package gfg;

import static java.lang.Integer.max;
import static util.CommonUtils.printArray;

public class LargestContiguousSumArrayPrint {

    private static int largestContiguousSum(int[] a) {
        int curSum = a[0], maxSum = a[0];
        for (int i = 1; i < a.length; i++) {
            curSum = max(a[i], curSum + a[i]);
            maxSum = max(maxSum, curSum);
        }
        return maxSum;
    }

    private static void maxSumSubarray(int[] a) {
        int curSum = a[0], maxSum = a[0], start = 0, end = 0, index = 0;
        for (int i = 1; i < a.length; i++) {
            if (curSum + a[i] < a[i]) {
                curSum = a[i];
                index  = i;
            } else {
                curSum += a[i];
            }
            if (maxSum < curSum) {
                maxSum = curSum;
                start  = index;
                end = i;
            }
        }
        printArray(a, start, end + 1);
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.print(largestContiguousSum(a) + "\t");
        maxSumSubarray(a);
        int[] b = {-2, -3, 4, 1};
        System.out.print(largestContiguousSum(b) + "\t");
        maxSumSubarray(b);
        int[] c = {2, 3, -1, 5, -3, 2};
        System.out.print(largestContiguousSum(c) + "\t");
        maxSumSubarray(c);
    }
}
