package leetcode;

import java.util.stream.IntStream;

public class MultiplyingLargeNumInsufficientDataTypeToHold {

    private static void multiplyArrays(int[] x, int[] y) {
        int k = x.length + y.length;
        int[] mul = new int[k];
        for (int i = x.length - 1; i >= 0; i--) {
            int carry = 0, sum = 0;
            for (int j = y.length - 1; j >= 0; j--) {
                sum = x[i] * y[j] + carry + mul[k - 1];
                carry = sum / 10;
                mul[--k] = sum % 10;
            }
            mul[--k] = carry;
            k += y.length;
        }
        IntStream.range(0, mul.length).forEach(j -> System.out.print(mul[j]));
    }

    public static void main(String[] args) {
        multiplyArrays(new int[]{1, 2}, new int[]{1, 0});
    }
}
