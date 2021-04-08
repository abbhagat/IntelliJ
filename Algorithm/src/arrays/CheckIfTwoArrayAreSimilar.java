package goldmansach;

import java.util.ArrayList;
import java.util.List;

// same solution as of anagram

public class CheckIfTwoArrayAreSimilar {

    public static void main(String[] args) {

        int[] a = {1, 2, 4, 3, 5, 5, 4, 7};
        int[] b = {7, 5, 4, 5, 4, 3, 2, 1};
        if (a.length != b.length) {
            System.out.println("Different Array");
            System.exit(0);
        }
        List<Integer> al = new ArrayList<>();
        for (int v : a) {
            al.add(v);
        }
        for (int v : b) {
            al.remove(Integer.valueOf(v));
        }
        System.out.println(al.size() == 0 ? "Same Array" : "Different Array");

    }

}
