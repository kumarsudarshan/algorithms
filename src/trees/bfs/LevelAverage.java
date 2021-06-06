package trees.bfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, populate an array to represent the averages of all of its levels.
 */
public class LevelAverage {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(doBFS(root)); // [1.0, 2.5, 5.5]
    }

    public static List<Double> doBFS(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Double> currentLevel = new ArrayList<>(level);
            int levelSum = 0;
            for (int i = 0; i < level; i++) { // traverse all nodes of that level
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                // push children's to the queue if exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add((double) (levelSum / (double) level));
        }
        return result;
    }
}
