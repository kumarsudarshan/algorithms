package graph.disjointset;

/*
https://www.geeksforgeeks.org/disjoint-set-data-structures/
 */
public class DisjointSet {

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
