package trees.dfs;

import trees.TreeNode;
/*
Given a binary tree, find the length of its diameter. The diameter of a tree is the number of nodes on the longest path between any two leaf nodes. The diameter of a tree may or may not pass through the root.
Note: You can always assume that there are at least two leaf nodes in the given tree.
        1
      /   \
     2     3
   /     /   \
  4     5     6
 Output - 5 (4->2->1->3->6)
 */
public class TreeDiameter {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(calculateHeight(root));
        System.out.println(treeDiameter);
    }

    static int treeDiameter = 0;
    public static int calculateHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftTreeHeight = calculateHeight(root.left);
        int rightTreeHeight = calculateHeight(root.right);

        int diameter =  1 + leftTreeHeight + rightTreeHeight;
        // update the global treeDiameter
        treeDiameter = Math.max(treeDiameter, diameter);

        // height of binary tree = max of either child + 1.
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
