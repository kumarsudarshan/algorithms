package graph.topologicalsort;

import java.util.*;

/*
You are given map of Roman empire. There are N+1 cities (numbered from 0 to N)
and N directed roads between them.
The capital of Roman empire is Rome.
All cities is connected to rome.
Given 2 arrays A and B, return the number of the city which is rome.
If no such road from city to rome is found then return -1.

Example 1: A: [1,2,3], B: [0,0,0]
        2 -> 0 <- 3
            ^
            |
            1
       Result: 0, 0 is rome, all roads connect to rome.

Example 2: A: [0,1,2,4,5], B: [2,3,3,3,2], returns 3
    5           4
      \       /
       2 -> 3
      /      \
    0         1

Example 3: A: [2, 3, 3, 4], B: [1, 1, 0, 0], Return -1, There is no rome on map
    2 -> 1 <- 3 -> 0 <- 4
 */
public class FindRome {
    public static void main(String[] args) {
        System.out.println(findRome(new int[]{1, 2, 3}, new int[]{0, 0, 0}));
        System.out.println(findRome(new int[]{0, 1, 2, 4, 5}, new int[]{2, 3, 3, 3, 2}));
        System.out.println(findRome(new int[]{2, 3, 3, 4}, new int[]{1, 1, 0, 0}));
    }

    public static int findRome(int[] A, int[] B) {
        int vertices = A.length + 1;
        List<Integer> sortedOrder = new ArrayList<>();

        // initialize the graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // build the graph
        for (int i = 0; i < A.length; i++) {
            int parent = A[i];
            int child = B[i];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // find all sources i.e. all vertices with 0 in-degree
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        List<Integer> result = new ArrayList<>();
        findRome(graph, inDegree, sources, sortedOrder, result);
        if (result.size() > 1) {
            return -1;
        }
        return result.get(0);
    }

    private static void findRome(Map<Integer, List<Integer>> graph, Map<Integer, Integer> inDegree, Queue<Integer> sources, List<Integer> sortedOrder, List<Integer> result) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);

                sourcesForNextCall.remove(vertex);
                List<Integer> children = graph.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sourcesForNextCall.add(child);
                }

                findRome(graph, inDegree, sourcesForNextCall, sortedOrder, result);

                sortedOrder.remove(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }

        if (sortedOrder.size() == inDegree.size()) {
            if (!result.contains(sortedOrder.get(sortedOrder.size() - 1))) {
                result.add(sortedOrder.get(sortedOrder.size() - 1));
            }
        }
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }
}
