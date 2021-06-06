package trees.dfs;

import trees.TreeNode;

/*
Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
        1
      /   \
     2     3
   /     /   \
  4     5     6
 Output - 16 (4->2->1->3->6)
 */
public class PathWithMaxSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(maxPathSum(root));
        System.out.println(maxPathSum);
    }

    static int maxPathSum = 0;

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreePathSum = maxPathSum(root.left);
        int rightTreePathSum = maxPathSum(root.right);
        // max path sum for any node is equal to left subtree path sum + right subtree path sum plus current node value.
        int currentMaxPathSum = leftTreePathSum + root.val + rightTreePathSum;
        // update the global maxPathSum
        maxPathSum = Math.max(currentMaxPathSum, maxPathSum);

        // max of sum of any path from the current node will be equal to the maximum of the sums from left or right subtrees plus the current code value.
        return Math.max(leftTreePathSum, rightTreePathSum) + root.val;
    }

}
