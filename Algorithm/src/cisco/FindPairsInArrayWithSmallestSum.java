package cisco;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindPairsInArrayWithSmallestSum {

    private static List<int[]> findPairsInArrayWithSmallestSum(int[] a, int[] b, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] + x[1] - (b[0] + b[1]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < a.length && i < k; i++) {
            pq.offer(new int[]{a[i], b[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            list.add(new int[]{cur[0], cur[1]});
            if (cur[2] == b.length - 1) {
                continue;
            }
            pq.offer(new int[]{cur[0], b[cur[2] + 1], cur[2] + 1});
        }
        return list;
    }

    public static void main(String[] args) {
        List<int[]> list = findPairsInArrayWithSmallestSum(new int[]{1, 2}, new int[]{3, 4}, 3);
        int[] a = list.get(0);
        int[] b = list.get(1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "," + b[i]);
        }
        System.out.println();
        list = findPairsInArrayWithSmallestSum(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        a = list.get(0);
        b = list.get(1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "," + b[i]);
        }
        System.out.println();
        list = findPairsInArrayWithSmallestSum(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        a = list.get(0);
        b = list.get(1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "," + b[i]);
        }
    }
}
