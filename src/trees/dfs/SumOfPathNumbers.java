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
public class SumOfPathNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(sumPathNumbers(root, 0)); // 408
    }

    public static int sumPathNumbers(TreeNode root, int pathSum) {
        if (root == null) {
            return pathSum;
        }
        // calculate path sum of the current node.
        pathSum = 10 * pathSum + root.val;
        // if leaf, return the current path sum
        if (root.left == null && root.right == null) {
            return pathSum;
        }
        // traverse left and right subtree
        return sumPathNumbers(root.left, pathSum) + sumPathNumbers(root.right, pathSum);
    }
}
