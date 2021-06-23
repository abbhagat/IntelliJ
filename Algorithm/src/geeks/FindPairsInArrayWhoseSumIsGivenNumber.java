package geeks;

import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseSumIsGivenNumber {

    private static int[] a = {2, 4, 5, 1, 7, 8, 3, 6, 9, 0};
    private static int[] b = {8, 3, 6, 9, 0};
    private static int n = 5;

    private static void findPair() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, 1);
        }
        for (int x : b) {
            if (map.containsKey(n - x)) {
                System.out.println(x + " " + (n - x));
            }
        }
    }

    public static void main(String[] args) {
        findPair();
    }
}
