package geeksforgeeks;

import java.util.stream.IntStream;

import static util.Swap.swap;

// Time Complexity :- O(n * n!)
public class AllPermutationOfArrayNum {

    private static void permutation(int[] a, int start, int end) {
        if (start == end) {
            IntStream.range(0, a.length).forEach(i -> System.out.print(a[i]));
            System.out.println();
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(a, i, start);
            permutation(a, start + 1, end);
            swap(a, i, start);
        }
    }

    public static void main(String[] args) {
        permutation(new int[]{1, 2, 3}, 0 , 2);
        Double d = 1000d;
        System.out.println("Normal value :" + d);
        System.out.println("Without decimal points :" + d.longValue());
        System.out.println(String.valueOf(Double.parseDouble("1.0")).split("\\.")[0]);
    }
}
