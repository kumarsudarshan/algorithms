package trees.dfs;

import trees.TreeNode;

/*
Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
        1
      /  \
     7    9
        /   \
       2     9
Sequence - [1,9,9]
 Output = true
 */

public class PathWithSequence {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        int[] sequence = {1, 9, 9};
        System.out.println(isSequence(root, sequence));
    }

    private static boolean isSequence(TreeNode root, int[] sequence) {
        if (root == null) {
            return sequence.length == 0;
        }
        return isSequenceHelper(root, sequence, 0);
    }

    private static boolean isSequenceHelper(TreeNode root, int[] sequence, int sequenceIndex) {
        if (root == null || sequenceIndex >= sequence.length || root.val != sequence[sequenceIndex]) {
            return false;
        }
        // if current node is leaf and it is the end of the sequence, then we found the answers
        if (root.left == null && root.right == null && sequence[sequenceIndex] == root.val) {
            return true;
        }

        return isSequenceHelper(root.left, sequence, sequenceIndex + 1) || isSequenceHelper(root.right, sequence, sequenceIndex + 1);
    }


}
