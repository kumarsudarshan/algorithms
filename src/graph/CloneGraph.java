package graph;

import java.util.*;

/*
Clone Graph
https://leetcode.com/problems/clone-graph/
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

 */
public class CloneGraph {
    public static void main(String[] args) {
        Node node = new Node(5);
        node.neighbors = Arrays.asList(new Node(1), new Node(2), new Node(3));
        print(node);

        Node cloned = clone(node);
        print(cloned);
    }

    public static void print(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.val + " : " + temp.hashCode());
            if (temp.neighbors != null) {
                for (Node n : temp.neighbors) {
                    queue.add(n);
                }
            }
        }
    }

    public static Node clone(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node n : current.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    queue.add(n);
                }
                map.get(current).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

