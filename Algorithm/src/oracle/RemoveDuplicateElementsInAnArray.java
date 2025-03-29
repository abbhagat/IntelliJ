package oracle;

import util.CommonUtils;

import java.util.Arrays;
import java.util.Map;

public class RemoveDuplicateElementsInAnArray {

    private static void removeDuplicates(int[] a) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for(int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        System.out.println(map.keySet());
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 7, 1, 6, 8, 9, 10, 3000, 6, 3, 5, 10, 2000, 4, 9, 10};
        removeDuplicates(a);
        Arrays.sort(a);
        CommonUtils.printArray(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] != a[i]) {
                System.out.print(a[i - 1] + " ");
            }
        }
        System.out.println(a[a.length - 1]);
    }
}
