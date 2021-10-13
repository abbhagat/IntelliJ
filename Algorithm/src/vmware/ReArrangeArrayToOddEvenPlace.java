package vmware;

import java.util.stream.IntStream;

public class ReArrangeArrayToOddEvenPlace {

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 4, 7, 9, 24, 98};
        int oddIdx = 0, evenIdx = 1;
        while (oddIdx < a.length - 1 && evenIdx < a.length) {
            if (a[oddIdx] % 2 == 1) {
                oddIdx += 2;
            } else {
                if (a[evenIdx] % 2 == 1) {
                    int t = a[oddIdx];
                    a[oddIdx] = a[evenIdx];
                    a[evenIdx] = t;
                } else {
                    evenIdx += 2;
                }
            }
        }
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
