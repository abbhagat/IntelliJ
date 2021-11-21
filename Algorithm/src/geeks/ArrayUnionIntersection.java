package geeks;

import java.util.HashSet;
import java.util.Set;

public class ArrayUnionIntersection {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] a = {12, 55, 60, 72, 89, 35, 35, 46, 12, 46, 100};
        int[] b = {12, 15, 30, 23, 10, 60, 35, 89, 92, 100, 10, 23, 45, 60};
        for (int x : a) {
            set.add(x);
        }
        System.out.println("Intersection");
        for (int x : b) {
            if (!set.add(x)) {
                System.out.print(x + " ");
            }
        }
        System.out.println("\nUnion\n" + set);
    }
}
