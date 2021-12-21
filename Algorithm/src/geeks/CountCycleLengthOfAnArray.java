package geeks;

import java.util.LinkedList;

public class CountCycleLengthOfAnArray {

    public static int countLengthOfCycle(int[] a, int startIndex) {
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0, i = startIndex;
        while (i < a.length) {
            list.add(a[i]);
            i = list.getLast();
            count++;
            if (list.contains(a[i])) {
                if (a[i] == a[startIndex]) {
                    return count;
                } else {
                    int j = 0;
                    while (j < a.length) {
                        if (a[i] == a[j]) {
                            break;
                        }
                        j++;
                    }
                    return list.size() - j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(countLengthOfCycle(new int[]{1, 0}, 0));
        System.out.println(countLengthOfCycle(new int[]{1, 2, 0}, 0));
        System.out.println(countLengthOfCycle(new int[]{1, 2, 3, 4, 5, 3}, 0));
    }
}
