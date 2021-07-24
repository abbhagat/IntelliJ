package arrays;

import java.util.Arrays;

public class UnionOfTwoArrays {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 5, 7};
        int b[] = {1, 2, 4, 5, 6};
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println("Intersection ");
        for (int i = 0, j = 0; i < a.length && j < b.length; i++, j++) {
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println("\nUnion ");
        for(int x : a){
            System.out.print(x + " ");
        }
        for (int i = 0, j = 0; i < a.length && j < b.length; i++, j++) {
            if (a[i] != b[j]) {
                System.out.print(b[j] + " ");
            }
        }
    }

}
