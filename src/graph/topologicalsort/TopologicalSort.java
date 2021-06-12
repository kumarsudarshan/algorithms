package graph.topologicalsort;

import java.util.*;

/*
Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.

Given a directed graph, find the topological ordering of its vertices.

Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
Output: Following are the two valid topological sorts for the given graph:
1) 3, 2, 0, 1
2) 3, 2, 1, 0

Input: Vertices=5, Edges=[4, 2], [4, 3], [2, 0], [2, 1], [3, 1]
Output: Following are all valid topological sorts for the given graph:
1) 4, 2, 3, 0, 1
2) 4, 3, 2, 0, 1
3) 4, 3, 2, 1, 0
4) 4, 2, 3, 1, 0
5) 4, 2, 0, 3, 1

Input: Vertices=7, Edges=[6, 4], [6, 2], [5, 3], [5, 4], [3, 0], [3, 1], [3, 2], [4, 1]
Output: Following are all valid topological sorts for the given graph:
1) 5, 6, 3, 4, 0, 1, 2
2) 6, 5, 3, 4, 0, 1, 2
3) 5, 6, 4, 3, 0, 2, 1
4) 6, 5, 4, 3, 0, 1, 2
5) 5, 6, 3, 4, 0, 2, 1
6) 5, 6, 3, 4, 1, 2, 0

There are other valid topological ordering of the graph too.
 */
public class TopologicalSort {
    public static void main(String[] args) {
        System.out.println(sort(new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}}, 4)); // [3, 2, 0, 1]
        System.out.println(sort(new int[][]{{4, 2}, {4, 3}, {2, 0}, {2, 1}, {3, 1}}, 5)); // [4, 2, 3, 0, 1]
        System.out.println(sort(new int[][]{{6, 4}, {6, 2}, {5, 3}, {5, 4}, {3, 0}, {3, 1}, {3, 2}, {4, 1}}, 7)); // [5, 6, 3, 4, 0, 2, 1]
    }

    public static List<Integer> sort(int[][] edges, int vertices) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0) {
            return sortedOrder;
        }

        // 1. initialize the graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // 2. Build the graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
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

        if (sortedOrder.size() != vertices) { // this means graph has cycle, hence topological sort not possible.
            return new ArrayList<>();
        }
        return sortedOrder;
    }
}
