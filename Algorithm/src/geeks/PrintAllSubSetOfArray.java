package geeks;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: array = {1, 2, 3}
 * Output: // this space denotes null element.
 * 1
 * 1 2
 * 1 2 3
 * 1 3
 * 2
 * 2 3
 * 3
 * Explanation: These are all the subsets that can be formed using the array.
 * Input: 1 2
 * Output:
 * 1
 * 2
 * 1 2
 * Explanation: These are all the subsets that can be formed using the array.
 */

public class PrintAllSubSetOfArray {

    public static void findSubSet(int[] a, int index, List<Integer> list) {
        if (index == a.length) {
            System.out.println(list);
        } else {
            findSubSet(a, index + 1, list);
            list.add(a[index]);
            findSubSet(a, index + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        findSubSet(new int[]{1, 2, 3}, 0, new ArrayList<>());
    }
}
