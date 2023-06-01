package paypal;

import java.util.LinkedList;

public class SubsetWithSumDivByN {

    static class BooleanWrapper {
        boolean flag;
    }

    private static void findSubset(int[] a, int index, LinkedList<Integer> list, int k, BooleanWrapper booleanWrapper) {
        if (index == a.length) {
            int sum = list.stream().reduce(0, Integer::sum);
            if (sum % k == 0) {
                booleanWrapper.flag = true;
            }
            return;
        }
        findSubset(a, index + 1, list, k, booleanWrapper);
        list.add(a[index]);
        findSubset(a, index + 1, list, k, booleanWrapper);
        list.removeLast();
    }

    public static void main(String[] args) {
        BooleanWrapper booleanWrapper = new BooleanWrapper();
        findSubset(new int[]{1, 2, 4}, 0, new LinkedList<>(), 3, booleanWrapper);
        System.out.println(booleanWrapper.flag);
    }
}
