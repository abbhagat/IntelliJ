package gfg;

import static java.lang.Math.max;
import static util.CommonUtils.printArray;

public class LargestContiguousSumArrayPrint {

    private static int largestContiguousSum(int[] a) {
        int curSum = a[0], maxSum = a[0];
        for(int x : a) {
            curSum = max(x ,  x + curSum);
            maxSum = max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
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
        System.out.println(maxSum + "\t" + largestContiguousSum(a));
        printArray(a, start, end);
    }
}
