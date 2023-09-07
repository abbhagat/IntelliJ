package paypal;

import java.util.LinkedList;

public class SubsetWithSumDivByN {

    private static void findSubset(int[] a, int index, LinkedList<Integer> list, int n) {
        if (index == a.length) {
            int sum = list.stream().reduce(0, Integer::sum);
            if (sum % n == 0 && !list.isEmpty()) {
                System.out.println(list);
            }
            return;
        }
        list.add(a[index]);
        findSubset(a, index + 1, list, n);
        list.removeLast();
        findSubset(a, index + 1, list, n);
    }

    public static void main(String[] args) {
        findSubset(new int[]{1, 2, 4}, 0, new LinkedList<>(), 3);
    }
}
