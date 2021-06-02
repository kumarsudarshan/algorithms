package mergeintervals;

import java.util.Arrays;

/*
Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.

Appointments: [[6,7], [2,4], [8,12]]
Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.

Appointments: [[4,5], [2,3], [3,6]]
Output: false
Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 */

public class ConflictingAppointments {
    public static void main(String[] args) {
        System.out.println(isConflicts(new Interval[]{new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)}));
        System.out.println(isConflicts(new Interval[]{new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)}));
        System.out.println(isConflicts(new Interval[]{new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)}));
    }

    public static boolean isConflicts(Interval[] intervals) {
        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // find any overlapping appointment
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                // *** note = here '<' and not '<=',
                // because there is no conflict on appointment if intervals[i].start == intervals[i - 1].end
                return false;
            }
        }
        return true;
    }
}
