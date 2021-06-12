package heap.kwaymerge;

import java.util.PriorityQueue;

/*
Kth Smallest Number in a Sorted Matrix (Hard)
Given an N∗N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.
Input: Matrix=[
    [2, 6, 8],
    [3, 7, 10],
    [5, 8, 11]
  ],
  K=5
Output: 7
Explanation: The 5th smallest number in the matrix is 7.
 */
public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        System.out.println(findKthSmallest(matrix, 5));
    }

    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        // adding first element in each row
        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node(i, 0));
        }

        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k) { // if number count matches k we traverse till k elements.
                break;
            }
            node.col++; // move to next element of current row.
            if (matrix[0].length > node.col) { // add the updated node if within range
                minHeap.add(node);
            }
        }
        return result;
    }
}

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}