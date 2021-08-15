package graph.disjointset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Commutable Islands
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
We need to find bridges with minimal cost such that all islands are connected.
It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
Input Format:
The first argument contains an integer, A, representing the number of islands.
The second argument contains an 2-d integer matrix, B, of size M x 3:
    => Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
Output Format:
Return an integer representing the minimal cost required.
Constraints:
1 <= A, M <= 6e4
1 <= B[i][0], B[i][1] <= A
1 <= B[i][2] <= 1e3
Examples:
Input 1:
    A = 4
    B = [   [1, 2, 1]
            [2, 3, 4]
            [1, 4, 3]
            [4, 3, 2]
            [1, 3, 10]  ]

Output 1:
    6

Explanation 1:
    We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.

Input 2:
    A = 4
    B = [   [1, 2, 1]
            [2, 3, 2]
            [3, 4, 4]
            [1, 4, 3]   ]

Output 2:
    6

Explanation 2:
    We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 */
public class CommutableIslands {
    public static void main(String[] args) {
        int A = 4;
        List<List<Integer>> B = new ArrayList<>();
        B.add(Arrays.asList(1, 2, 1));
        B.add(Arrays.asList(2, 3, 4));
        B.add(Arrays.asList(1, 4, 3));
        B.add(Arrays.asList(4, 3, 2));
        B.add(Arrays.asList(1, 3, 10));

        System.out.println(solve(A, B));
    }

    public static int solve(int A, List<List<Integer>> B) {
        int totalCost = 0;
        Collections.sort(B, (a, b) -> a.get(2) - b.get(2));
        DisjointSet djs = new DisjointSet(A + 1);

        for (List<Integer> list : B) {
            int u = list.get(0);
            int v = list.get(1);
            int cost = list.get(2);
            if (djs.union(u, v)) {
                totalCost += cost;
            }
        }
        return totalCost;
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
