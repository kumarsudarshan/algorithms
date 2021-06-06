package trees.bfs;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
/*
Given a binary tree and a node, find the level order successor of the given node in the tree.
The level order successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(findSuccessor(root, 3).val); // 4
    }

    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            TreeNode currentNode = queue.poll();
            // push children's to the queue if exists
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            // if key matches with any node, the very next item in the queue is the answer.
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }
}
