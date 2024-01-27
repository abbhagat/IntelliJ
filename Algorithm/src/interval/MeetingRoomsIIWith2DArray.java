package interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MeetingRoomsIIWith2DArray {

    private static int findMinRooms(int[][] a) {
        Arrays.sort(a, Comparator.comparingInt(i -> i[0]));
        Arrays.sort(a, Comparator.comparingInt(i -> i[1]));
        LinkedList<int[]> intervals = new LinkedList<>();
        intervals.add(a[0]);
        int n = 1;
        for (int i = 1; i < a.length; i++) {
            if (intervals.getLast()[0] < a[i][0] || intervals.getLast()[1] <= a[i][0]) {
                intervals.add(a[i]);
            } else {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(findMinRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(findMinRooms(new int[][]{{7, 10}, {2, 4}}));
        System.out.println(findMinRooms(new int[][]{{0, 5}, {1, 2}, {6, 10}}));
        System.out.println(findMinRooms(new int[][]{{0, 5}, {1, 2}, {1, 10}}));
        System.out.println(findMinRooms(new int[][]{{0, 1}, {0, 2}, {2, 3}, {1, 3}, {2, 4}, {3, 5}}));
        System.out.println(findMinRooms(new int[][]{{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}}));
    }
}
