package graph.topologicalsort;

import java.util.*;

/*
Tasks Scheduling Order (medium)
There are ‘N’ tasks, labelled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a method to find the ordering of tasks we should pick to finish all tasks.

Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
Output: [0, 1, 2]
Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs to finish
before '2' can be scheduled. A possible scheduling of tasks is: [0, 1, 2]

Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
Output: []
Explanation: The tasks have cyclic dependency, therefore they cannot be scheduled.

Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
Output: [0 1 4 3 2 5]
Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5]
 */
public class TaskSchedulingOrder {
    public static void main(String[] args) {
        System.out.println(scheduleOrder(new int[][]{{0, 1}, {1, 2}}, 3));
        System.out.println(scheduleOrder(new int[][]{{0, 1}, {1, 2}, {2, 0}}, 3));
        System.out.println(scheduleOrder(new int[][]{{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}}, 6));
    }

    public static List<Integer> scheduleOrder(int[][] prerequisites, int tasks) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0) {
            return sortedOrder;
        }

        // 1. initialize the graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // 2. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // 3. find all sources i.e. all vertices with 0 in-Degree
        Queue<Integer> source = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                source.add(entry.getKey());
            }
        }

        // 4. For each source, add it to the sortedOrder and subtract one from all of its children in-degree
        // if it's child in-degree becomes zero, add it to the source queue.
        while (!source.isEmpty()) {
            int vertex = source.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    source.add(child);
                }
            }
        }

        if (sortedOrder.size() != tasks) { // this means graph has cycle, hence topological sort not possible. i.e. not possible to schedule all tasks
            return new ArrayList<>();
        }
        return sortedOrder;
    }
}
