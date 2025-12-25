package interval;

import util.Interval;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Time  Complexity : O(n log n)
// Space Complexity : O(n)
public class MeetingRoomsII {

  private static int findMinRooms(List<Interval> intervalList) {
    intervalList.sort((interval1, interval2) -> interval1.start - interval2.start);  // Comparator.comparingInt(interval -> interval.start)
    intervalList.sort((interval1, interval2) -> interval1.end - interval2.end);     //  Comparator.comparingInt(interval -> interval.end)
    LinkedList<Interval> mergeInterval = new LinkedList<>();
    int n = 1;
    for (Interval interval : intervalList) {
      if (mergeInterval.isEmpty() || mergeInterval.getLast().start < interval.start || mergeInterval.getLast().end <= interval.start) {
        mergeInterval.add(interval);
      } else {
        n++;
      }
    }
    return n;
  }

  private static int findMinRooms(int[][] a) {
    Arrays.sort(a, (x, y) -> x[0] - y[0]);  // Comparator.comparingInt(x -> x[0])
    Arrays.sort(a, (x, y) -> x[1] - y[1]); //  Comparator.comparingInt(x -> x[1])
    LinkedList<int[]> mergeInterval = new LinkedList<>();
    mergeInterval.add(a[0]);
    int n = 1;
    for (int i = 1; i < a.length; i++) {
      if (mergeInterval.getLast()[0] < a[i][0] || mergeInterval.getLast()[1] <= a[i][0]) {
        mergeInterval.add(a[i]);
      } else {
        n++;
      }
    }
    return n;
  }

  public static void main(String[] args) {
    System.out.println(findMinRooms(List.of(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20))));
    System.out.println(findMinRooms(List.of(new Interval(7, 10), new Interval(2, 4))));
    System.out.println(findMinRooms(List.of(new Interval(0, 5), new Interval(1, 2), new Interval(6, 10))));
    System.out.println(findMinRooms(List.of(new Interval(0, 5), new Interval(1, 2), new Interval(1, 10))));
    System.out.println(findMinRooms(List.of(new Interval(0, 1), new Interval(0, 2), new Interval(2, 3), new Interval(1, 3), new Interval(2, 4), new Interval(3, 5))));
    System.out.println(findMinRooms(List.of(new Interval(1, 18), new Interval(18, 23), new Interval(15, 29), new Interval(4, 15), new Interval(2, 11), new Interval(5, 13))));

    System.out.println();

    System.out.println(findMinRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    System.out.println(findMinRooms(new int[][]{{7, 10}, {2, 4}}));
    System.out.println(findMinRooms(new int[][]{{0, 5}, {1, 2}, {6, 10}}));
    System.out.println(findMinRooms(new int[][]{{0, 5}, {1, 2}, {1, 10}}));
    System.out.println(findMinRooms(new int[][]{{0, 1}, {0, 2}, {2, 3}, {1, 3}, {2, 4}, {3, 5}}));
    System.out.println(findMinRooms(new int[][]{{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}}));
  }
}
