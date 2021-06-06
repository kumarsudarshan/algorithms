package trees.bfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinMaxDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(11);
        System.out.println(minDepth(root)); // 3
        System.out.println(maxDepth(root)); // 4
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;
            int level = queue.size();
            List<Integer> currentLevel = new ArrayList<>(level);
            for (int i = 0; i < level; i++) { // traverse all nodes of that level
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) { // traversing level wise, so if leaf found means this is with minimum depth.
                    return minDepth;
                }
                // push children's to the queue if exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return minDepth;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int level = queue.size();
            List<Integer> currentLevel = new ArrayList<>(level);
            for (int i = 0; i < level; i++) { // traverse all nodes of that level
                TreeNode currentNode = queue.poll();
                // push children's to the queue if exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return maxDepth;
    }

}
