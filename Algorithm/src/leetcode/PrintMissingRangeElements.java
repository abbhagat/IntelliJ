package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Time Complexity: O(n + (high-low+1))
// Auxiliary Space: O(n)
public class PrintMissingRangeElements {

    private static void printMissingRange(int[] a, int start, int end) {
        Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        IntStream.range(start, end + 1).forEach(x -> {
            if (!set.contains(x)) {
                System.out.print(x + " ");
            }
        });
    }

    public static void main(String[] args) {
        printMissingRange(new int[]{10, 12, 11, 15}, 10, 15);
        System.out.println();
        printMissingRange(new int[]{1, 3, 5, 4}, 1, 10);
        System.out.println();
        printMissingRange(new int[]{1, 14, 11, 51, 15}, 50, 55);
        System.out.println();
    }
}
