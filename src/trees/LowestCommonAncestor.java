package trees;

/*
Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Input: root = [1,2], p = 1, q = 2
Output: 1
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        TreeNode root = new TreeNode(3, left, right);
        left.left = new TreeNode(6);
        left.right = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        right.left = new TreeNode(9);
        right.right = new TreeNode(8);

        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(4);
        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        System.out.println("Ancestor for " + p.val + " and " + q.val + " is " + ancestor.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
