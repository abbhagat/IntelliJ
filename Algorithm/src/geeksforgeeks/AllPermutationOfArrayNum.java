package geeksforgeeks;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity :- O(n * n!)
public class AllPermutationOfArrayNum {

    private static void permutation(int[] a, int start, int end) {
        if (start == end) {
            printArray(a);
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
    }
}
