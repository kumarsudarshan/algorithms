package trees.dfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).

            1
          /   \
         7     9
       /  \  /   \
      6   5  2   3
 Sum = 12
 Output: = 3 (7->5, 1->9->2, 9->3)
 */
public class CountPathForSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        List<Integer> pathLists = new ArrayList<>();
        System.out.println(countPathSum(root, 12, pathLists));
    }

    public static int countPathSum(TreeNode root, int sum, List<Integer> currentPath) {
        if (root == null) {
            return 0;
        }
        // add current node to the path
        currentPath.add(root.val);
        int pathCount = 0, pathSum = 0;
        // find the sums of all sum-paths in the current path list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            // if the sum of any sub-path is equal to sum, then we increment the path count.
            if (pathSum == sum) {
                pathCount++;
            }
        }
        // traverse the left and right child.
        pathCount += countPathSum(root.left, sum, currentPath) + countPathSum(root.right, sum, currentPath);
        // remove the current no    de from the path to backtrack.
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }
}
