package graph.topologicalsort;

import java.util.*;

/*
Reconstructing a Sequence (hard)
Given a sequence originalSeq and an array of sequences, write a method to find if originalSeq can be uniquely reconstructed from the array of sequences.
Unique reconstruction means that we need to find if originalSeq is the only sequence such that all sequences in the array are subsequence’s of it.
Input: originalSeq: [1, 2, 3, 4], seqs: [[1, 2], [2, 3], [3, 4]]
Output: true
Explanation: The sequences [1, 2], [2, 3], and [3, 4] can uniquely reconstruct
[1, 2, 3, 4], in other words, all the given sequences uniquely define the order of numbers
in the 'originalSeq'.
Input: originalSeq: [1, 2, 3, 4], seqs: [[1, 2], [2, 3], [2, 4]]
Output: false
Explanation: The sequences [1, 2], [2, 3], and [2, 4] cannot uniquely reconstruct
[1, 2, 3, 4]. There are two possible sequences we can construct from the given sequences:
1) [1, 2, 3, 4]
2) [1, 2, 4, 3]
Input: originalSeq: [3, 1, 4, 2, 5], seqs: [[3, 1, 5], [1, 4, 2, 5]]
Output: true
Explanation: The sequences [3, 1, 5] and [1, 4, 2, 5] can uniquely reconstruct
[3, 1, 4, 2, 5]
 */
public class ReconstructSequence {
    public static void main(String[] args) {
        System.out.println(reconstruct(new int[]{1, 2, 3, 4}, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(reconstruct(new int[]{1, 2, 3, 4}, new int[][]{{1, 2}, {2, 3}, {2, 4}}));
        System.out.println(reconstruct(new int[]{3, 1, 4, 2, 5}, new int[][]{{3, 1, 5}, {1, 4, 2, 5}}));

    }

    public static boolean reconstruct(int[] originalSeq, int[][] sequences) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (originalSeq.length <= 0) {
            return false;
        }

        // 1. initialize the graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] seq : sequences) {
            for (int i = 0; i < seq.length; i++) {
                inDegree.putIfAbsent(seq[i], 0);
                graph.putIfAbsent(seq[i], new ArrayList<>());
            }
        }

        // 2. build the graph
        for (int[] seq : sequences) {
            for (int i = 1; i < seq.length; i++) {
                int parent = seq[i - 1];
                int child = seq[i];
                inDegree.put(child, inDegree.get(child) + 1);
                graph.get(parent).add(child);
            }
        }

        // if we don't have ordering rules for all the numbers we will not be able to uniquely construct the sequence.
        if (inDegree.size() != originalSeq.length) {
            return false;
        }

        // 3. Find all source with  0 indegree
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // 4. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            if (sources.size() > 1) {
                return false; // more than one sources mean, there is more than one way to reconstruct the sequence
            }

            if (originalSeq[sortedOrder.size()] != sources.peek()) {
                return false; // the next source (or number) is different from the original sequence
            }
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }

        }
        // if sortedOrder's size is not equal to original sequence's size, there is no unique way to construct
        return sortedOrder.size() == originalSeq.length;
    }
}
