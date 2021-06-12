package graph.topologicalsort;

import java.util.*;

/*
Tasks Scheduling (medium)
There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.

Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
Output: true
Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs to finish
before '2' can be scheduled. A possible sceduling of tasks is: [0, 1, 2]

Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
Output: false
Explanation: The tasks have cyclic dependency, therefore they cannot be sceduled.

Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
Output: true
Explanation: A possible sceduling of tasks is: [0 1 4 3 2 5]
 */
public class TaskScheduling {
    public static void main(String[] args) {
        System.out.println(schedulePossible(new int[][]{{0, 1}, {1, 2}}, 3));
        System.out.println(schedulePossible(new int[][]{{0, 1}, {1, 2}, {2, 0}}, 3));
        System.out.println(schedulePossible(new int[][]{{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}}, 6));
    }

    public static boolean schedulePossible(int[][] prerequisites, int tasks) {
        List<Integer> order = new ArrayList<>();
        if (tasks <= 0) {
            return false;
        }

        // 1. initialize the graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // 2. build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // 3. Find all source with 0 inDegrees
        Queue<Integer> source = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                source.add(entry.getKey());
            }
        }

        // 4. For each source, add it to the order and subtract all of it's children indegree
        // if children's indegree == 0, then add it to the source
        while (!source.isEmpty()) {
            int vertex = source.poll();
            order.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    source.add(child);
                }
            }
        }

        // if order.size() == tasks, means all tasks will get finished.
        return order.size() == tasks;
    }
}
