package amazon;

import java.util.ArrayList;
import java.util.List;

public class CheckIfTwoArrayAreSimilar {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3, 5, 5, 4, 7};
        int[] b = {7, 5, 4, 5, 4, 3, 2, 1};
        List<Integer> al = null;
        if (a.length == b.length) {
            al = new ArrayList<>();
            for (int x : a) {
                al.add(x);
            }
            for (int x : b) {
                al.remove(Integer.valueOf(x));
            }
        }
        System.out.println(al != null ? al.isEmpty() ? "Same Array" : "Different Array" : "Different Array");
    }
}