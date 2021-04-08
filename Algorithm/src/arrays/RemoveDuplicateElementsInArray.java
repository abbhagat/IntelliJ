package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/*
 * Soln 1 :  using a hashmap
 * Soln 2 :  using a BST
 * Soln 3 :  O(n^2)
 * Soln 4 :  using sorting
 *
 */

public class RemoveDuplicateElementsInArray {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 1, 3, 2, 3, 4, 5, 6, 1, 2, 8, 9, 11, 10, 1, 8, 9, 10, 7, 7, 11};
        Set<Integer> hs = new HashSet<>();
        Arrays.sort(a); // a = {1 1 1 1 2 2 2 3 3 3 4 4 5 6 7 7 8 8 9 9 10 10 11 11}
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
        int i;
        for (i = 1; i < a.length; i++) {
            if (a[i - 1] == a[i]) {
                hs.add(a[i]);
            } else {
                System.out.print(a[i - 1] + " ");
            }
        }
        i--;
        System.out.println(a[i]);
        System.out.println();
        System.out.print("Repeated elemnts in the array are : ");
        System.out.println(hs);
    }
}
