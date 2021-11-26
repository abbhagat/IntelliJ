package searching;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers from 1 to 10 in any order and one number is repeated find the repeated num.
 * int[] a = { 10, 7, 3, 4, 5, 1, 2, 8, 6 ,8};
 * Here 8 occurs twice i.e 9 must be present but 8 got repeated. you have to find the missing no
 *
 * Soln 1 : Using a BST.
 * Soln 2 : Using HashMap in O(n)
 */
public class FindRepeatedNumInAnArray {

    public static void main(String[] args) {
        int[] a = {10, 7, 3, 4, 5, 1, 2, 8, 6, 9, 9, 3, 0, 2, 1, 1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x,  map.getOrDefault(x,0) + 1);
        }
        map.forEach((k, v) -> {
            if (v > 1) {
                System.out.print(k + " ");
            }
        });
    }
}
