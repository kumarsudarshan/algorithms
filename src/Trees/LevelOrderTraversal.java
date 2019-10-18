/*
    Created by : Kumar Sudarshan
    Date : 11th Feb 2018
    Level Order Traversal
 */

package Trees;


import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String args[]) {
    	BinaryTreeNode root = BinaryTree.createBinaryTree();
        levelOrderTraversal(root);
    }

    static void levelOrderTraversal(BinaryTreeNode root) {

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            System.out.print("\t" + temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }
}
