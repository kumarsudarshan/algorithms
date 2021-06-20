package trees;

/*
Flatten Binary Tree to Linked List
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points
to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Input: root = []
Output: []

Input: root = [0]
Output: [0]
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // before
        inorder(root); // 3  2  4  1  5  6
        System.out.println();
        preorder(root); // 1  2  3  4  5  6
        System.out.println();

//        flattenRecur(root);
        flattenMorrisTraversal(root);

        // after
        inorder(root); // 1  2  3  4  5  6
        System.out.println();
        preorder(root); // 1  2  3  4  5  6

    }

    // Time complexity : O(n), Space complexity : O(height) - because using recursion
    public static void flattenRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flattenRecur(left);
        flattenRecur(right);

        root.right = left;
        TreeNode current = root;
        // update right child only when whole left subtree got processed.
        // when left's subtrees right child becomes null then append right to the current node.
        while (current.right != null) {
            current = current.right;
        }
        current.right = right;
    }

    // Time complexity : O(n), Space complexity : O(1)
    public static void flattenMorrisTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left != null) {
                TreeNode left = root.left;
                TreeNode current = left;
                while (current.right != null) {
                    current = current.right;
                }
                // Morris Traversal main step
                // take right most node of left subtree and attach to right child of root.
                current.right = root.right;
                root.left = null;
                root.right = left;
            }
            root = root.right;
        }
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + "  ");
            inorder(root.right);
        }
    }

    public static void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "  ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
