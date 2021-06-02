package mergeintervals;
/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Example 1:

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].
 */

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(7, 9));

        mergeIntervals(intervals).forEach(i -> System.out.println("[" + i.start + ", " + i.end + "]"));
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<Interval>();

        if (intervals.size() < 2) { // only 1 or 0 or null interval, no need to merge.
            return intervals;
        }

        // sort the intervals by start time.
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if (interval.start <= end) {
                // overlapping intervals, so adjust the end.
                // No need to adjust start, as we already sorted the whole intervals by start time.
                end = Math.max(interval.end, end);
            } else {
                // non overlapping interval, so add it in the answers
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
