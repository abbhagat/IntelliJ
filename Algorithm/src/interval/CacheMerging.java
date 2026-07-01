package interval;

import util.Interval;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time complexity O(n), where n is the number of intervals in the intervalList.
public class CacheMerging {

  private static int getEnd(Interval interval) {
    return interval.start + interval.end;
  }

  private static void insertInterval(List<Interval> intervalList, Interval newInterval) {
    int i = 0;
    while (i < intervalList.size() && getEnd(intervalList.get(i)) < newInterval.start) {
      i++;
    }
    while (i < intervalList.size() && getEnd(intervalList.get(i)) >= newInterval.start) {
      Interval interval = intervalList.remove(i);
      int start = min(interval.start, newInterval.start);
      int end   = max(getEnd(interval), getEnd(newInterval));
      newInterval.start = start;
      newInterval.end   = end - start;
    }
    intervalList.add(i, newInterval);
  }

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
    List<Interval> intervalList = List.of(new Interval(1, 4), new Interval(6, 4), new Interval(6, 9));
    intervalList.forEach(interval -> {
      insertInterval(list, interval);
      System.out.println(list);
    });
  }
}
