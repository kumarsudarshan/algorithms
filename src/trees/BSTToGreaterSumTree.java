package trees;

/*
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original
BST is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

public class BSTToGreaterSumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        inOrder(root);
        allGreaterNodeSum(root);
        System.out.println();
        inOrder(root);
    }

    static int sum = 0;

    public static void allGreaterNodeSum(TreeNode root) {
        if (root == null) {
            return;
        }
        allGreaterNodeSum(root.right);
        root.val += sum;
        sum = root.val;
        allGreaterNodeSum(root.left);
    }

    static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "\t");
            inOrder(root.right);
        }
    }
}
