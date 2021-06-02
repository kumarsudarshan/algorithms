package mergeintervals;

import java.util.*;

/*
Given a list of non-overlapping intervals sorted by their start time,
insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 */

public class InsertIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 12));

        mergeIntervals(intervals, new Interval(4, 6)).forEach(i -> System.out.println("[" + i.start + ", " + i.end + "]"));
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.isEmpty()){
            return Arrays.asList(newInterval);
        }
        List<Interval> mergedIntervals = new ArrayList<Interval>();

        int i = 0;
        // skip and add interval to answers if end of any interval is less than new interval start,
        // as there is no chance of overlapping between two.
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        // merge all intervals that overlap with newInterval
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        // insert the newInterval
        mergedIntervals.add(newInterval);

        // add all remaining intervals to answers.
        while(i < intervals.size()){
            mergedIntervals.add(intervals.get(i));
            i++;
        }
        return mergedIntervals;
    }
}
