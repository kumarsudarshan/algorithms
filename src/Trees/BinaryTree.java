/*
    Created by : Kumar Sudarshan
    Date : 11th Feb 2018
    Binary Tree Creation
 */

package Trees;

public class BinaryTree {
    static BinaryTreeNode root = null;

    public static void main(String args[]) {
        root = createBinaryTree(root);
        BinaryTreeTraversal.traverseBinaryTree(root);
    }

    static BinaryTreeNode createBinaryTree(BinaryTreeNode root) {
        root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getLeft().getLeft().setLeft(new BinaryTreeNode(6));
        return root;
    }

}
