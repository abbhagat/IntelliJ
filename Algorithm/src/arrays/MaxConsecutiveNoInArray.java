package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxConsecutiveNoInArray {

    public static void main(String[] args) {

        int[] a = { 12, -93, -92, -91, -90, 6, -5, -4, 3, 2, -1, 1002, 1001, 1000, 95, 89, 94 };
        Arrays.sort(a);
        List<Integer> al = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i - 1] - a[i]) == 1) {
                if (!al.contains(a[i - 1])) {
                    al.add(a[i - 1]);
                }
                if (!al.contains(a[i])) {
                    al.add(a[i]);
                }
            }
        }
        System.out.println("Consecutives are :" + al);
        System.out.println(al.size());
    }
}
