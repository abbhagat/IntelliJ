package leetcode;

import java.util.stream.IntStream;

public class MultiplyingLargeNumInsufficientDataTypeToHold {

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5};
        int[] y = {1, 4, 5, 0, 0};
        int k = x.length + y.length;
        int[] mul = new int[k];
        for (int i = x.length - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = y.length - 1; j >= 0; j--) {
                int sum = x[i] * y[j] + carry + mul[k - 1];
                carry = sum / 10;
                mul[--k] = sum % 10;
            }
            mul[--k] = carry;
            k += y.length;
        }
        IntStream.range(0, mul.length).forEach(j -> System.out.print(mul[j]));
    }
}
