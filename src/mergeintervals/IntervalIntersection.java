package mergeintervals;

/*
Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.

Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]
Explanation: The output list contains the common intervals between the two lists.

Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
Output: [5, 7], [9, 10]
Explanation: The output list contains the common intervals between the two lists.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
    public static void main(String[] args) {
        Interval[] interval1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] interval2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Arrays.stream(intersection(interval1, interval2)).forEach(i -> System.out.print("[" + i.start + ", " + i.end + "]\t"));

        System.out.println();
        interval1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        interval2 = new Interval[]{new Interval(5, 10)};
        Arrays.stream(intersection(interval1, interval2)).forEach(i -> System.out.print("[" + i.start + ", " + i.end + "]\t"));
    }

    public static Interval[] intersection(Interval[] interval1, Interval[] interval2) {
        List<Interval> results = new ArrayList<>();
        int i = 0, j = 0;
        while (i < interval1.length && j < interval2.length) {
            // check if interval1 intersects interval2
            // check if one of the interval's start time lies within the other interval.
            if ((interval1[i].start >= interval2[j].start && interval1[i].start <= interval2[j].end)
                    || (interval2[j].start >= interval1[i].start && interval2[j].start <= interval1[i].end)) {
                // store the intersection part
                results.add(new Interval(Math.max(interval1[i].start, interval2[j].start), Math.min(interval1[i].end, interval2[j].end)));
            }

            // move next interval, which is finishing first
            if (interval1[i].end < interval2[j].end) {
                i++;
            } else {
                j++;
            }
        }
        return results.toArray(new Interval[results.size()]);
    }

}
