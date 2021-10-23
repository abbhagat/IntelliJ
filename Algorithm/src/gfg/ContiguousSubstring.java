package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class ContiguousSubstring {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(x -> x.start));
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).end) {
                intervals.remove(i + 1);
                i--;
                continue;
            }
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = intervals.get(i + 1).end;
                intervals.remove(i + 1);
                i--;
                continue;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        System.out.println(merge(null));
    }
}
