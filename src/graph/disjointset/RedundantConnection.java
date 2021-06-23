package graph.disjointset;

import java.util.Arrays;

/*
Redundant Connection
https://leetcode.com/problems/redundant-connection/

You are given a graph that started as a tree with n nodes labelled from 1 to n,
with one additional edge added. The added edge has two different vertices chosen from 1 to n,
and was not an edge that already existed.
The graph is represented as an array edges of length n where edges[i] = [ai, bi]
indicates that there is an edge between nodes ai and bi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes.
If there are multiple answers, return the answer that occurs last in the input.

Input: edges = [[1,2],[1,3],[2,3]] Output: [2,3]

Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]] Output: [1,4]
 */
public class RedundantConnection {

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int[] result = findRedundantConnection(edges);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [2, 3]

        int[][] edges1 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5},
                {1, 3}
        };
        // [1, 3] - here [1, 4] is also an answer but we have te return the answer that occurs last in the input.
        int[] result1 = findRedundantConnection(edges1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");
    }

    static int MAX_NODES = 1000;

    public static int[] findRedundantConnection(int[][] edges) {
        DisjointSet djs = new DisjointSet(MAX_NODES + 1);
        int i = 0, j = 0;
        for (int[] edge : edges) {
            if (!djs.union(edge[0], edge[1])) {
                j = i;
            }
            i++;
        }
        return edges[j];
    }

    private static class DisjointSet {

        int[] parent;
        int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return false;
            } else if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[x] >= rank[y]) {
                parent[y] = x;
                rank[x]++;
            }
            return true;
        }
    }
}
