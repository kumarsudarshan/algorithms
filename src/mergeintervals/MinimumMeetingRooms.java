package mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a list of intervals representing the start and end time of ‘N’ meetings,
find the minimum number of rooms required to hold all the meetings.

Meetings: [[1,4], [2,5], [7,9]]
Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
occur in any of the two rooms later.

Meetings: [[6,7], [2,4], [8,12]]
Output: 1
Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.

Meetings: [[1,4], [2,3], [3,6]]
Output:2
Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
hold all the meetings.

Meetings: [[4,5], [2,3], [2,4], [3,5]]
Output: 2
Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 */

public class MinimumMeetingRooms {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(7, 9));

        System.out.println(findMinimumMeetingRooms(intervals));

        intervals.clear();
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(8, 12));

        System.out.println(findMinimumMeetingRooms(intervals));

        intervals.clear();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(3, 6));

        System.out.println(findMinimumMeetingRooms(intervals));

        intervals.clear();
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(3, 5));

        System.out.println(findMinimumMeetingRooms(intervals));
    }

    public static int findMinimumMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        int minRooms = 0;

        // Sorting only by start time will not help here.
        // So, sorting both separately by start time(collection sort) and end time(using min heap)
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.size(), (a, b) -> Integer.compare(a.end, b.end));
        for (Interval interval : intervals) {
            // remove all meetings that have ended.
            while (!minHeap.isEmpty() && interval.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            // add current meeting into minHeap
            minHeap.offer(interval);

            // all active meeting are in the minHeap
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

}
