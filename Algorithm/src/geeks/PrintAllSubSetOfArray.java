package geeks;

import java.util.LinkedList;

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
// O((2^n))
// O(n)
public class PrintAllSubSetOfArray {

    public static void findSubSet(int[] a, int index, LinkedList<Integer> list) {
        if (index == a.length) {
            System.out.println(list);
        } else {
            findSubSet(a, index + 1, list);
            list.add(a[index]);
            findSubSet(a, index + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        findSubSet(new int[]{1, 2, 3}, 0, new LinkedList<>());
    }
}
