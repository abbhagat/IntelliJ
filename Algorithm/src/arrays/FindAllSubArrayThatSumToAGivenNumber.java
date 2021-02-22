package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllSubArrayThatSumToAGivenNumber {

    private static int[] a = {15, -2, 2, -8, 1, 7, 10, 23};
    private static Map<String, Integer> map = new HashMap<>();
    private static List<Integer> al = new ArrayList<>();

    private static void combinationForSum(int index, int curSum, int givenSum) {
        if (curSum == givenSum) {
            map.put(al.toString(), al.size());
        }
        if (curSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            curSum += a[i];
            al.add(a[i]);
            combinationForSum(i + 1, curSum, givenSum);
            al.remove(al.size() - 1);
            curSum -= a[i];
        }
    }

    public static void main(String[] args) {
        combinationForSum(0, 0, 10);
        map.forEach((k,v) -> System.out.println(k + " --> " + v));
    }
}
