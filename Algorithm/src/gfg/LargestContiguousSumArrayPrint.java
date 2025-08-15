package gfg;

import static java.lang.Math.max;
import static util.CommonUtils.printArray;

public class LargestContiguousSumArrayPrint {

    private static void largestContiguousSum(int[] a) {
        int curSum = a[0], maxSum = a[0];
        for(int x : a) {
            curSum = max(x ,  x + curSum);
            maxSum = max(maxSum, curSum);
        }
        System.out.println(maxSum);
    }

    private static void largestContinuousSum(int[] a) {
        int curSum, maxSum, start, end, s;
        curSum = maxSum = a[0];
        start = end = s = 0;
        for (int i = 1; i < a.length; i++) {
            curSum = max(a[i]  , curSum + a[i]);
            maxSum = max(maxSum, curSum);
            if (curSum < maxSum) {
                start = s;
                end   = i;
            }
            if (maxSum < 0) {
                s = i + 1;
            }
        }
        System.out.println(maxSum);
        printArray(a, start, end);
    }
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        largestContiguousSum(a);
        largestContinuousSum(a);
        System.out.println();
        int[] b = {-2, -3, 4, 1};
        largestContiguousSum(b);
        largestContinuousSum(b);
    }
}
