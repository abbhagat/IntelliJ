package pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindAllPairsInArrayWithSmallestDiff {

    private static List<Integer> findPairs(List<Integer> list) {
        Collections.sort(list);
        int target = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) != list.get(i + 1)) {
                target = Integer.min(target, list.get(i + 1) - list.get(i));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == target) {
                result.add(list.get(i));
                result.add(list.get(i + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(Arrays.asList(6, 2, 4, 10)));
        System.out.println(findPairs(Arrays.asList(5, 4, 3, 2)));
        System.out.println(findPairs(Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854)));
    }
}
