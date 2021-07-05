package arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class MaxConsecutiveNoInArray {

    public static void main(String[] args) {

        int[] a = {12, -93, -92, -91, -90, 6, -5, -4, 3, 2, -1, 1002, 1001, 1000, 95, 89, 94};
        Arrays.sort(a);
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == 1) {
                set.add(a[i - 1]);
                set.add(a[i]);
            }
        }
        System.out.println("Consecutive are :" + set);
        System.out.println(set.size());
    }
}
