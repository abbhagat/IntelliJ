package arrays;

import java.util.stream.IntStream;

public class ArrayMulOtherThanOwnPosition {

    public static void main(String[] args) {
        int mul = 1, a[] = {2, 3, 4, 5};
        for (int i : a) {
            mul *= i;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = mul / a[i];
        }
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
