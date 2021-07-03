package searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindFirstMissingPositiveNumber {

    public static int firstMissingPositive(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, 1);
        }
        Arrays.sort(a);
        int firstPositiveNum = 0;
        for (int x : a) {
            if (x > 0) {
                firstPositiveNum = x;
                break;
            }
        }
        while (true) {
            if (map.containsKey(firstPositiveNum)) {
                firstPositiveNum++;
            } else {
                break;
            }
        }
        return firstPositiveNum;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{2, 3, -7, 6, 8, 1, -10, 15}));
    }
}
