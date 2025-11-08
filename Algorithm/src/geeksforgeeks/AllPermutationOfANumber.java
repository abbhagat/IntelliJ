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

    private static int[] convert(int n) {
        String s = String.valueOf(n);
        int l = s.length();
        int[] a = new int[l];
        for (int i = 0; i < l; i++) {
            a[i] = Character.getNumericValue(s.charAt(i));
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = convert(123);
        permutation(a, 0, a.length - 1);
        System.out.println();
        a = convert(102);
        permutation(a, 0, a.length - 1);
    }
}
