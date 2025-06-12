package amazon;

import java.util.ArrayList;
import java.util.List;

// Time  Complexity : O(n)
public class CheckIfTwoArrayAreSimilar {

    private static boolean isSimilar(int[] a, int[] b) {
        if (a.length == b.length) {
            List<Integer> list = new ArrayList<>();
            for (int x : a) {
                 list.add(x);
            }
            for (int x : b) {
                 list.remove(Integer.valueOf(x));
            }
            return list.isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 4, 3, 5};
        int[] b = {5, 4, 3, 1, 1};
        int[] c = {5, 7, 3, 2, 9};
        int[] d = {5, 7, 3, 2};
        System.out.println(isSimilar(a, b) ? "Same Array" : "Different Array");
        System.out.println(isSimilar(a, c) ? "Same Array" : "Different Array");
        System.out.println(isSimilar(b, d) ? "Same Array" : "Different Array");
    }
}
