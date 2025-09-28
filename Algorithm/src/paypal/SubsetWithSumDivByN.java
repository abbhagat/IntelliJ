package paypal;

import java.util.LinkedList;

public class SubsetWithSumDivByN {

    private static void findSubset(int[] a, int index, int sum, int n, LinkedList<Integer> list) {
        if (index == a.length) {
            if (sum % n == 0 && !list.isEmpty()) {
                System.out.println(list);
            }
            return;
        }
        sum += a[index];
        list.add(a[index]);
        findSubset(a, index + 1, sum, n, list);
        sum -= a[index];
        list.removeLast();
        findSubset(a, index + 1, sum, n, list);
    }

    public static void main(String[] args) {
        findSubset(new int[]{1, 2, 4},    0, 0, 3, new LinkedList<>());
        System.out.println("------------");
        findSubset(new int[]{1, 2, 3, 4}, 0, 0, 5, new LinkedList<>());
    }
}
