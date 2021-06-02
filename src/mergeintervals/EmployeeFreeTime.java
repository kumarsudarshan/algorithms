package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
For ‘K’ employees, we are given a list of intervals representing the working hours of each employee. Our goal is to find out if there is a free interval that is common to all employees. You can assume that each list of employee working hours is sorted on the start time.

Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
Output: [3,5]
Explanation: Both the employess are free between [3,5].

Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
Output: [4,6], [8,9]
Explanation: All employess are free between [4,6] and [8,9].

Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
Output: [5,7]
Explanation: All employess are free between [5,7].
 */

public class EmployeeFreeTime {

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(new ArrayList(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        schedule.add(new ArrayList(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        employeeFreeTime(schedule).forEach(interval -> System.out.print("[" + interval.start + ", " + interval.end + "]\t"));

        System.out.println();
        schedule.clear();
        schedule.add(new ArrayList(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        schedule.add(new ArrayList(Arrays.asList(new Interval(2, 4))));
        schedule.add(new ArrayList(Arrays.asList(new Interval(6, 8))));
        employeeFreeTime(schedule).forEach(interval -> System.out.print("[" + interval.start + ", " + interval.end + "]\t"));

        System.out.println();
        schedule.clear();
        schedule.add(new ArrayList(Arrays.asList(new Interval(1, 3))));
        schedule.add(new ArrayList(Arrays.asList(new Interval(2, 4))));
        schedule.add(new ArrayList(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        employeeFreeTime(schedule).forEach(interval -> System.out.print("[" + interval.start + ", " + interval.end + "]\t"));

    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.start - b.start);

        // add all intervals in minHeap, which is sorted based on start time.
        for (List<Interval> list : schedule) {
            for (Interval i : list) {
                minHeap.add(i);
            }
        }

        List<Interval> freeTime = new ArrayList<>();
        int max = -1;
        while (!minHeap.isEmpty()) {
            Interval top = minHeap.poll();
            if (max != -1 && top.start > max) {
                // (max, top.start) is the gap interval, so add it to the answer.
                freeTime.add(new Interval(max, top.start));
            }
            max = Math.max(max, top.end);
        }
        return freeTime;
    }
}

