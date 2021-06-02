package mergeintervals;

import java.util.*;

/*
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.

Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
jobs are running at the same time i.e., during the time interval (2,4).

Jobs: [[6,7,10], [2,4,11], [8,12,15]]
Output: 15
Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.

Jobs: [[1,4,2], [2,4,1], [3,6,5]]
Output: 8
Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
 */

public class MaximumCPULoad {

    public static void main(String[] args) {
        System.out.println(findMinimumMeetingRooms(new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)))));
        System.out.println(findMinimumMeetingRooms(new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)))));
    }

    public static int findMinimumMeetingRooms(List<Job> jobs) {
        if (jobs == null || jobs.isEmpty()) {
            return 0;
        }
        int maxCpuLoad = 0;
        int currentCpuLoad = 0;

        // Sorting only by start time will not help here.
        // So, sorting both separately by start time(collection sort) and end time(using min heap)
        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Job> minHeap = new PriorityQueue<Job>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));
        for (Job job : jobs) {
            // remove all jobs that have ended.
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end) {
                currentCpuLoad = currentCpuLoad - minHeap.poll().cpuLoad;
            }
            // add current job into minHeap
            minHeap.offer(job);
            currentCpuLoad = currentCpuLoad + job.cpuLoad;
            maxCpuLoad = Math.max(maxCpuLoad, currentCpuLoad);
        }
        return maxCpuLoad;
    }
}

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
}