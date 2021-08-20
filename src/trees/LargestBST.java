package trees;

import java.util.Arrays;
import java.util.List;

/*
Find the largest BST subtree in a given Binary Tree
Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST).
If the complete Binary Tree is BST, then return the size of whole tree.

Input:
      5
    /  \
   2    4
 /  \
1    3

Output: 3

The following subtree is the maximum size BST subtree
   2
 /  \
1    3


Input:
       50
     /    \
  30       60
 /  \     /  \
5   20   45    70
              /  \
            65    80
Output: 5
The following subtree is the maximum size BST subtree
      60
     /  \
   45    70
        /  \
      65    80
 */
public class LargestBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);

        System.out.println(largestBST(root).get(1)); // 3
        System.out.println(largestBSTSum(root).get(1)); // 6

        root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        System.out.println(largestBST(root).get(1)); // 5
        System.out.println(largestBSTSum(root).get(1)); // 320
    }

    public static List<Integer> largestBST(TreeNode root) { // format for list - (isBST, size, min, max)
        if (root == null) {
            return Arrays.asList(1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // if leaf
        if (root.left == null && root.right == null) {
            return Arrays.asList(1, 1, root.val, root.val);
        }

        List<Integer> left = largestBST(root.left);
        List<Integer> right = largestBST(root.right);

        if (left.get(0) == 1 && right.get(0) == 1) {
            if (root.val > left.get(3) && root.val < right.get(2)) {
                int leftMin = left.get(2);
                int rightMax = right.get(3);
                if (leftMin == Integer.MAX_VALUE) { // case when a node have no left child
                    leftMin = root.val;
                }
                if (rightMax == Integer.MIN_VALUE) { // case when a node have no right child
                    rightMax = root.val;
                }
                return Arrays.asList(1, left.get(1) + right.get(1) + 1, leftMin, rightMax);
            }
        }
        return Arrays.asList(0, Math.max(left.get(1), right.get(1)), 0, 0);
    }

    public static List<Integer> largestBSTSum(TreeNode root) { // format for list - (isBST, size, min, max)
        if (root == null) {
            return Arrays.asList(1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // if leaf
        if (root.left == null && root.right == null) {
            return Arrays.asList(1, root.val, root.val, root.val);
        }

        List<Integer> left = largestBSTSum(root.left);
        List<Integer> right = largestBSTSum(root.right);

        if (left.get(0) == 1 && right.get(0) == 1) {
            if (root.val > left.get(3) && root.val < right.get(2)) {
                int leftMin = left.get(2);
                int rightMax = right.get(3);
                if (leftMin == Integer.MAX_VALUE) { // case when a node have no left child
                    leftMin = root.val;
                }
                if (rightMax == Integer.MIN_VALUE) { // case when a node have no right child
                    rightMax = root.val;
                }
                return Arrays.asList(1, left.get(1) + right.get(1) + root.val, leftMin, rightMax);
            }
        }
        return Arrays.asList(0, Math.max(left.get(1), right.get(1)), 0, 0);
    }
}
