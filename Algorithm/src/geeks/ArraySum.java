package geeks;

import java.util.*;

public class ArraySum {

    private static int[] a = {0, 15, -2, 2, -8, 1, 7, 10, 23};
    private static List<Integer> al = new ArrayList<>();
    private static Map<String,Integer> map = new HashMap<>();

    public static void combinationForSum(int index, int givenSum, int curSum) {

        if (curSum == givenSum) {
            map.put(al.toString(),al.size());
        }

        if (curSum > givenSum) {
            return;
        }

        for (int i = index; i < a.length; i++) {
            curSum += a[i];
            al.add(a[i]);
            combinationForSum(i + 1, givenSum, curSum);
            al.remove(al.size() - 1);
            curSum -= a[i];
        }
    }

    public static void main(String[] args) {
        Arrays.sort(a);
        combinationForSum(0, 0, 0);
        System.out.println(map);
    }
}
