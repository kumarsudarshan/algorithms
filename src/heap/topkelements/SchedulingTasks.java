package heap.topkelements;

import java.util.*;

/*
You are given a list of tasks that need to be run, in any order, on a server. Each task will take one CPU interval to execute but once a task has finished, it has a cooling period during which it can’t be run again. If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals that the server needs to finish all tasks.
If at any time the server can’t execute any task then it must stay idle.
Input: [a, a, a, b, c, c], K=2
Output: 7
Explanation: a -> c -> b -> a -> c -> idle -> a
Input: [a, b, a], K=3
Output: 5
Explanation: a -> b -> idle -> idle -> a

 */
public class SchedulingTasks {
    public static void main(String[] args) {
        System.out.println(scheduleTasks(new char[]{'a', 'a', 'a', 'b', 'c', 'c'}, 2));
        System.out.println(scheduleTasks(new char[]{'a', 'b', 'a'}, 3));
    }

    public static int scheduleTasks(char[] tasks, int k) {
        int intervalCount = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : tasks) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitingList = new ArrayList<>();
            int n = k + 1; // try to execute as many as 'k+1' tasks from the max heap
            for (; n > 0 && !maxHeap.isEmpty(); n--) {
                intervalCount++;
                Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
                if (currentEntry.getValue() > 1) {
                    currentEntry.setValue(currentEntry.getValue() - 1);
                    waitingList.add(currentEntry);
                }
            }
            maxHeap.addAll(waitingList); // put all waiting list back to the heap
            if (!maxHeap.isEmpty()) {
                intervalCount += n; // we will be having 'n' idle intervals for the next iteration.
            }
        }
        return intervalCount;
    }
}
