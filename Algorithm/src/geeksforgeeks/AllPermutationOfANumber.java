package geeksforgeeks;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity :- O(n * n!)
public class AllPermutationOfANumber {

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
        int n = 123;
        int l = String.valueOf(n).length();
        int[] a = new int[l];
        for(int i = 0; i < l; i++) {
            a[i] = Character.getNumericValue(String.valueOf(n).charAt(i));
        }
        permutation(a, 0 , l - 1);
    }
}
